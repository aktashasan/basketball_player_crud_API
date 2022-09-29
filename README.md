# Basketball Player CRUD API

Basketball oyuncularını, oynadıkları pozisyona göre tablolara bütün crud işlemlerini yapan küçük bir api uygulamasıdır.

Bu api hibernate teknolojisini barındırır. spring-boot-starter-data-jpa repository dependency ile sorgu yazmadan veritabanına verilere crud işlemlerini yapmaktadır. 

Bu api Mysql veritabanını kullanmaktadır. Application.properties dosyasından api'nin veritabanını jpa repository'sini destekleyen herhangi bir database kullanılabilir.
## Bilgisayarınızda Çalıştırın

Projeyi klonlayın

```bash
  git clone https://github.com/aktashasan/basketball_player_crud_API
```

Proje dizinine gidin

```bash
  cd basketball_player_crud_API
```



  
## API Kullanımı

Api ayağa kalktığında database'e eklenecek pozisyonları kaydedecektir. Request atarken listede yollanıcalacak oyuncu mevkii bilgisi aşağıdakiler gibi gönderilmelidir.

* POINT_GUARD
* SHOOTING_GUARD
* SMALL_FORWARD
* POWER_FORWARD 
* CENTER

#### Öğeyi kaydet

```http
  Post /app/player/save
```

| Parametre | Tip      | Açıklama                |
| :-------- |:---------| :------------------------- |
| `firstName` | `String` | **Gerekli**. API anahtarınız. |
| `lastName` | `String` | **Gerekli**. API anahtarınız. |
| `positionList` | `List`   | **Gerekli**. API anahtarınız. |


```json
  {
  "firstName": "hasan",
  "lastName": "aktas",
  "positionList":[
    {
      "position":"CENTER"
    }
  ]
}
```

#### Öğeyi sil

```http
  GET /app/player/delete/${id}
```

| Parametre | Tip    | Açıklama                       |
| :-------- |:-------| :-------------------------------- |
| `id`      | `Long` | **id**. Çağrılacak öğeyi siler. |

#### Tüm öğeleri getir

```http
  GET /app/players/get
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `playerDto` | `List` | **playerDTO**. Çağrılacak öğeleri getirir. |
