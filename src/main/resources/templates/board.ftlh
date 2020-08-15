<#import "parts/common.ftlh" as c>

<@c.page title="Стена сообщений" activeTab="board">
    <div class="container">
        <div class="row board-input-row justify-content-center">
            <form action="/newMessage" method="post" id="input-new-message" class="text-center">
                <div class="column">
                    <div class="custom-input-form form-group">
                        <div class="row">
                    <textarea placeholder="Введите текст"
                              class="col-12"
                              type="text"
                              name="text"
                              id="text-area"
                              rows="3"></textarea>
                            <div class="col-4">
                            </div>
                        </div>
                        <div class="row">
                            <input placeholder="Введите тег"
                                   class="col-8"
                                   type="text"
                                   name="tag"
                                   id="tag">
                            <button type="submit"
                                    class="col-4"
                            >Добавить
                            </button>
                        </div>
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                </div>
            </form>
            <div id="space"></div>
            <form action="/filterMessages" method="post" class="text-center">
                <div class="column">
                    <div class="custom-input-form form-group">
                        <div class="row">
                            <input type="text" class="col-12"
                                   placeholder="Искать по нику автора">
                        </div>
                        <div class="row">
                            <input type="text" class="col-12"
                                   placeholder="Искать по тэгу">
                        </div>
                        <div class="row">
                            <input type="text" class="col-12"
                                   placeholder="Искать по паттерну текста">
                        </div>
                        <div class="row">
                            <input type="text" class="col-6" placeholder="Искать по id">
                            <button class="col-6">Фильтрировать</button>
                        </div>
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                </div>
            </form>
        </div>
        <div class="row">
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