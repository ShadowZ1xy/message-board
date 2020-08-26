<#import "parts/common.ftlh" as common>

<@common.page title="Пользователи" activeTab="user">
    <div class="container">
        <div class="mt-5">
            Список пользователей
        </div>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Имя</th>
                <th scope="col">Роль</th>
            </tr>
            </thead>
            <tbody>
            <#list users as user>
                <tr>
                    <th scope="row">${user.id}</th>
                    <td>${user.getUsername()}</td>
                    <td><#list user.roles as role>${role}<#sep>, </#list></td>
                    <td><a href="/user/${user.id}">редактировать</a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</@common.page>
