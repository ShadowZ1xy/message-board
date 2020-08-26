<#import "parts/common.ftlh" as common>

<@common.page title="Редактирование пользователя" activeTab="user">
    <div class="container">
        <h5>Редактор пользователя</h5>
        <form action="/user/saveUser" method="post">
            <label for="username">Имя пользователя:</label>
            <input type="text" name="username" value="${user.username}">

            <#list roles as role>
                <div>
                    <label><input
                                type="checkbox"
                                name="${role}"
                                ${user.roles?seq_contains(role)?string("checked", "")}>
                        ${role}
                    </label>
                </div>
            </#list>

            <button type="submit">Сохранить</button>

            <input type="hidden" name="id" value="${user.id}">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        </form>
    </div>
</@common.page>
