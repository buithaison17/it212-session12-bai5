# PROMPT REVIEW & REFACTOR SPRING BOOT

Bạn là Principal Software Engineer có hơn 15 năm kinh nghiệm trong lĩnh vực FinTech, Digital Banking và Spring Boot Enterprise.

Tôi sẽ cung cấp source code của chức năng Đăng ký mở tài khoản ngân hàng (Spring Boot).

Nhiệm vụ của bạn là đóng vai trò một Lead Developer thực hiện Code Review và Refactor toàn bộ hệ thống theo chuẩn Enterprise.

## Yêu cầu 1. Phân tích Code

Đọc toàn bộ source code và chỉ ra:

* Code Smell
* Technical Debt
* Vi phạm SOLID
* Vi phạm Clean Code
* Các đoạn code lặp
* Hard Code
* Long Method
* God Class
* Magic Number
* Thiếu Validation Layer
* Thiếu Logging
* Thiếu Exception Handling
* Thiếu DTO Mapping
* Thiếu Transaction
* Thiếu JavaDoc

Đối với từng lỗi cần ghi rõ:

* Mức độ ảnh hưởng
* Nguyên nhân
* Hướng cải thiện

---

## Yêu cầu 2. Refactor

Thực hiện refactor theo các nguyên tắc:

### Áp dụng SOLID

* Single Responsibility
* Open Closed
* Liskov
* Interface Segregation
* Dependency Injection

### Tách Validation

Không để validation trong Service.

Tạo:

```
validator/
    AccountValidator.java
```

Validation gồm:

* fullName
* phone
* email
* citizenId

Business Validation:

* CitizenId tồn tại
* Phone tồn tại
* Email tồn tại

---

### Global Exception

Sinh đầy đủ:

```
exception/

BusinessException.java

ResourceNotFoundException.java

DuplicateResourceException.java

GlobalExceptionHandler.java

ErrorResponse.java
```

ErrorResponse:

```
timestamp

status

error

message

path
```

Trả về JSON thống nhất.

---

### Logging

Sử dụng SLF4J.

Thêm log:

INFO

* Request bắt đầu
* Request thành công

WARN

* Validation lỗi

ERROR

* Exception

Không log thông tin nhạy cảm.

---

### Transaction

Các hàm ghi dữ liệu phải sử dụng

@Transactional

---

### Mapper

Tạo

```
mapper/

AccountMapper.java
```

Không mapping thủ công trong Service.

---

### Constant

Đưa các message ra

```
constant/

MessageConstant.java
```

Không Hard Code String.

---

### Utility

Nếu cần tạo

```
util/

AccountNumberGenerator.java
```

để sinh số tài khoản.

---

## Yêu cầu 3

Sau khi Refactor hãy sinh đầy đủ source code cho các class:

* Validator
* Exception
* Handler
* Mapper
* Service
* Controller
* Repository
* DTO
* Entity

Có JavaDoc đầy đủ.

Comment trong code bằng tiếng Việt.

---

## Yêu cầu 4

Lập bảng so sánh:

| Trước Refactor | Sau Refactor | Lợi ích |

---

## Yêu cầu 5

Đánh giá chất lượng source code theo thang điểm:

* Clean Code
* SOLID
* Maintainability
* Testability
* Readability
* Scalability

Cho điểm từ 1 đến 10 và giải thích lý do.
