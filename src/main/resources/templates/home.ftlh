<#import "parts/common.ftlh" as c>


<@c.page title="Главная страница" activeTab="home">
    <div class="container">
        <div class="row mt-5">
            <#list messages as message>
                <div class="card border-secondary mb-3 col-4">
                    <div class="card-header">Автор: ${message.author.username}</div>
                    <div class="card-body">
                        <h4 class="card-title">Тег: ${message.tag}</h4>
                        <p class="card-text">${message.text}</p>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</@c.page>