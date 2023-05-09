package com.globant.javacodecamp.paths;

public class NotificationService {

    public Result<String> notifyUser(PathWithTransport pathWithTransport){
        System.out.format("Path found for user: %s\n", pathWithTransport);
        return Result.success("User successfully notified!");
    }
}
