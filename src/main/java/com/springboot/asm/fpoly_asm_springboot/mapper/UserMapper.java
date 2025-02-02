package com.poly.mapper;

import com.poly.dto.request.UserCreationRequest;
import com.poly.dto.request.UserUpdatedRequest;
import com.poly.dto.response.UserResponse;
import com.poly.enity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdatedRequest request);
}
