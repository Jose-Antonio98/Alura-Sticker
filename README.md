<p align="center">
  <img src="https://user-images.githubusercontent.com/60453269/220384874-f136b1f9-a852-4774-a600-7fab9d77e8a2.png" alt="Logo" width="300" height="200" />
</p>

<h1 align="center"> ⭐ Alura Sticker </h1>

<p align="center">
  <b> ⭐ projeto realizado durante a imersão java da alura </b></br>
  <sub>
</p>


[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#table-of-contents)

<p align="center">
  <a href="#Introdução"> 🧩 Introdução </a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#Resultados"> 🚀 Resultados</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#Creditos"> 🏆 Créditos </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</p>

<br/>

<a id="Introdução"></a>
## 🧩 Introdução 

  Durante a imersão java realizada durante os dias 27 a 31 de março foi proposto a criação de um gerador de figurinhas utilizando a APIs do IMDB, Juntamente com a proposta de alguns desafios 
  propostos pelos intrutores foi deixado como um projeto em aberto para personalizações, com isso me propus a fazer com que o programa tivesse como padrão 3 APIs que estariam em um arquivo de texto fora do escopo do codigo para proteção,
  e permitindo assim a escolha do usuario de qual dos itens retornados pela API escolhida seria feito a figurinha. Além de fornecer a possibilidade do usuario adicionar sua propria API,
  e devido ao uso da programação orientada a objetos caso a API não seja totalmente compativel com a classe impletada esta pode ser impletada sem muitas modificações no codigo como um todo
              

<br/>


<a id="Resultados"></a>
## 🚀 Resultados 
  > Todos os resultados foram alcançados com sucesso. De modo geral são esses os resultados de cada requisição. 


⭐ Resultado |
|---|
![LotR3](https://user-images.githubusercontent.com/122057368/229655845-3bdd5748-6cc0-4be8-b784-d67580aa35c0.png)
  
  
[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#table-of-contents)


<br/>

## Back-end

<br/>

### ***⠀⠀⠀⠀⭐ Demostra fazer as requisições e a classe responsavel por tornar os dados legiveis ao programa***

  
### 🎯 Abrir requisição HTTP e Parseador do JSON utilizado
  
### ```Requisição HTTP```
```URL
  {
      URI address = URI.create(url);
			var client = HttpClient.newHttpClient();
			var request = HttpRequest.newBuilder(address).GET().build();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			return response.body();
  }

```
  
### ```JSON Parser```
  
      private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)\\].*");
      private static final Pattern REGEX_ATTRIBUTES_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");

      public List<Map<String, String>> parse(String json) {
      Matcher matcher = REGEX_ITEMS.matcher(json);
      if (!matcher.find()) {

        throw new IllegalArgumentException("Did not find items.");
      }

      String[] items = matcher.group(1).split("\\},\\{");

      List<Map<String, String>> data = new ArrayList<>();

      for (String item : items) {

        Map<String, String> itemAttributes = new HashMap<>();

        Matcher matcherAttributesJson = REGEX_ATTRIBUTES_JSON.matcher(item);
        while (matcherAttributesJson.find()) {
          String attributes = matcherAttributesJson.group(1);
          String value = matcherAttributesJson.group(2);
          itemAttributes.put(attributes, value);
        }

        data.add(itemAttributes);
      }

      return data;
    }
    
  
  
  <a id="Creditos"></a>
## 🏆 Créditos


<br />
⠀⠀

<br /> 

<div > 

| [<img src="https://user-images.githubusercontent.com/122057368/229660568-a0628ed7-4e7c-4cd3-98c2-7c70107f9e42.jpg" width=300><br><sub> José Antonio </sub>](https://www.linkedin.com/in/josé-antônio-chaves-junior/) | ***Hello 😃 Se você chegou até aqui, acredito que gostou do meu projeto, nesse caso temos algo em comum, sendo assim que tal conversamos um pouco? Meu chama no linkedin 😁*** | 
|---|---|


</div> 
 
