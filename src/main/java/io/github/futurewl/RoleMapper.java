package io.github.futurewl;

public interface RoleMapper {

    Role getRole(Long id);

    Role findRole(String roleName);

}
