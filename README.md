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

#### Tüm öğeleri getir

```http
  Post /app/player/save
```

| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `playerDTo` | `object` | **Gerekli**. API anahtarınız. |

#### Öğeyi getir

```http
  GET /app/player/delete/${id}
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **id**. Çağrılacak öğeyi siler. |

```http
  GET /app/players/get
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `playerDto` | `List` | **playerDTO**. Çağrılacak öğeleri getirir. |
