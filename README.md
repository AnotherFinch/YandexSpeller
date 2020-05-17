# YandexSpeller
Реализация клиентской части веб-сервиса
В POST-запросе, в отличие от GET-запроса, усложняется процесс наполнения Body. Он может содержать как текстовое содержимое, так и быть «составным», из данных различных типов. Рассмотрим сразу второй вариант.

HttpPost httPost = new HttpPost(“http://SomeURL/Service”);

Мы можем тут же наполнить Header сообщения, указав явно тип содержимого.

httpPost.addHeader(“Context-Type”, “multipart/form-data”);

И, само собой, нам требуется объект содержимого-сущности(Entity), он же наше Body.

HttpEntity reqEntity = MultipartEntityBuilder.create()

.addPart(“TxtPart1”, new StringBody(“data1”,ContextType.TEXT_PLAIN))

.addBinaryBody(“archivedFile”, new File(“C:/file.zip”), ContentType.create(application/x-zip-compressed”),  “C:/file.zip”)

.build();

httpPost.setEntity(reqEntity);

ClosableHttpResponse resp2= httpClient.execute(httpPost);

String sResp = EntityUtils.toString(resp2.getEntity());
