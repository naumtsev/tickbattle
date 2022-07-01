package ru.hse.services;

import io.grpc.stub.StreamObserver;
import ru.hse.AccountServiceGrpc;
import ru.hse.Account;

import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class AccountService extends AccountServiceGrpc.AccountServiceImplBase {
    private final ConcurrentHashMap<String, String> accounts = new ConcurrentHashMap<>();

    public AccountService() {
        super();
    }

    @Override
    public void login(Account.LoginRequest request, StreamObserver<Account.LoginResponse> responseObserver) {
        Account.LoginResponse.Builder response = Account.LoginResponse.newBuilder();
        String password = accounts.getOrDefault(request.getLogin(), null);
        if (password == null) {
            response.setSuccess(false).setComment("Account is not found");
        } else if (!request.getPassword().equals(password)) {
            response.setSuccess(false).setComment("Wrong password");
        } else {
            response.setSuccess(true);
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void registerAccount(Account.RegisterAccountRequest request, StreamObserver<Account.RegisterAccountResponse> responseObserver) {
        Account.RegisterAccountResponse.Builder response = Account.RegisterAccountResponse.newBuilder();

        String password = accounts.getOrDefault(request.getLogin(), null);

        if (password != null) {
            response.setSuccess(false).setComment("Account with the same login exists");
        } else if (Pattern.matches("^[A-Za-z0-9]{3,}$", request.getPassword())) {
            accounts.computeIfAbsent(request.getLogin(), (x) -> {
                response.setSuccess(true);
                return request.getPassword();
            });

            if (!response.getSuccess()) {
                response.setSuccess(false).setComment("Account with the same login exists");
            }
        } else {
            response.setSuccess(false).setComment("Password is invalid. It should contain 3 or more digits or latin letters");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}