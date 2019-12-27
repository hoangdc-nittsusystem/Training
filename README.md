# 1. OOP


--------
<div style="page-break-after: always;"></div>

# 2. Inner Class

--------
<div style="page-break-after: always;"></div>

# 3. Functional Interface
* Là interface có duy nhất một abstract method
* Lập trình hướng hàm: đưa hành vi vào hàm, kết hợp Anonymous Class

## Lambda Expression
* Chỉ dùng cho Functional Interface
* Định nghĩa ngắn gọn khi implement một Functional Interface
* Không có các thuộc tính riêng như implement Anonymous Class

## Built-in Functional Interfaces Java

Giới hạn tối đa 2 tham số truyền vào method

Functions | method name | parameter | return 
--- | --- | --- | ---
Consumer | accept | T | void
Function | apply | T | R
Supplier | get | void | T
Predicate | test | T | boolean
BiConsumer |  |  | 
BiFunction |  |  | 
BiPredicate |  |  | 
UnaryOperator | apply | T | T
BinaryOperator | apply | T , T | T

### Functional Interface với 3 tham số đầu vào

### Method reference
Nếu trong lambda expression chỉ có một method thì sử dụng method reference để ngắn gọn hơn
```java
// Class and static method
// Using a lambda expression
findNumbers(list, (i1, i2) -> Numbers.isMoreThanFifty(i1, i2));

// Using a method reference
findNumbers(list, Numbers::isMoreThanFifty);

// Class 
// Using a lambda expression
calculateOnShipments(l, s -> s.calculateWeight());

// Using a method reference
calculateOnShipments(l, Shipment::calculateWeight);
```



--------
<div style="page-break-after: always;"></div>

# 4. Collection
Xử lí tập hợp các Object, không chứa các giá trị nguyên thủy như integer, float, ...

![Tổng quan](https://viettuts.vn/images/java/java-collection/he-thong-cap-bac-colection-trong-java.png)

* List: mảng các Object có index
* Queue: Hàng đợi
* Set: tập hợp các Object không có index và không trùng nhau. Nếu trùng nhau Set tự gộp các phần tử giống nhau này
* Map: tập hợp `key-value`. Trong đó các key là duy nhất, nếu trùng nhau Map lấy phần tử được khai báo cuối cùng

## Colection và Map
Collection | Map
--- | ---
add() | put()
remove() | remove()
contains() | containsKey()
... | get()

## ArrayList và LinkedList
ArrayList   |   LinkedList
----------- |   -----------
Mảng động | Danh sách liên kết đôi
Thay đổi chậm hơn, mỗi khi xóa phần tử phải dịch bit tất cả các phần tử còn lại | Nhanh hơn, ko dịch bit
Duyệt mảng nhanh hơn vì các phần tử gần nhau hơn trong bộ nhớ | Lấy phần tử đầu hoặc cuối nhanh hơn
Chỉ kế thừa từ List | Kế thừa từ List và Queue, Deque
Phù hợp lưu và đọc data | Phù hợp cho thao tác thay đổi data

## Queue và Stack: ArrayDeque
Data Structure | Thêm | Lấy phần tử | Lấy và xóa
--- | --- | --- | ---
Queue | offer() | peek() | poll()
Stack | push() | peek() | poll()

## Hash và Tree
HashSet / HashMap | TreeSet / TreeMap
---- | ----
Lưu dạng hash | Lưu dạng binary tree
Các phần tử ko sắp xếp | Có sắp xếp, được kế thừa từ `SortedMap/SortedSet`
Tìm, thêm, xóa: O(1) | O(logn)
Cho phép null | Ko cho phép null
Hàm so sánh phần tử là `.equal()` | `.compareTo()`
Phù hợp với dữ liệu ko yêu cầu sắp xếp | Phù hợp dữ liệu yêu cầu sắp xếp

## Array to ArrayList
```
ArrayList<Integer> listInt = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
```
--------
<div style="page-break-after: always;"></div>


# 5. Generics

--------
<div style="page-break-after: always;"></div>

# 6. Stream
Stream ở đây thực chất là stream pipeline, nó bao gồm một loạt các thao tác với chuỗi dữ liệu (stream). Stream pipeline hay được gọi tắt đi là stream tuy nhiên hai khái niệm này hoàn toàn khác nhau

Đặc điểm:
* Không lưu trữ dữ liệu mà thao tác trên dữ liệu lấy từ nguồn
* Không thay đổi dữ liệu gốc
* Nếu có 1 thao tác đầu cuối được thực hiện trên 1 stream thì stream này ko duyệt đc mặc dù địa chỉ trên bộ nhớ ko đổi. Muốn duyệt ta phải tạo lại một stream mới.

Sử dụng:
* Tạo stream (stream source)
* Thực hiện thao tác trung gian (Intermediate Operations): `map`, `filter`, `sorted`
* Thực hiện thao tác đầu cuối (Terminal Operations) để trả về kết quả cuối cùng của loạt thao tác trên dữ liệu: `collect`, `forEach`, `reduce`

### Nguồn lấy stream:
* Collection `cl.stream()` hoặc `cd.parallelStream()`
* `Arrays.stream( Object [])`
* `BufferedReader.lines()`
* File class method

### Intermediate Operator:
* `map`: duyệt qua từng phần tử tập hợp, tham số truyền vào là emplement của Function Interface
```
stream.map(x -> x.toUpperCase());
stream.map(x -> x*x);
```
* `filter`: duyệt qua từng phần tử tập hợp, loại phần tử dựa theo điều kiện. Nếu true được giữ lại, false thì bị loại bỏ: Predicate Interface
```
stream.filter(x -> x.equals("Java"));
stream.filter(x -> x > 3);
```
* `sorted`:  sắp xếp các phần tử theo một thứ tự xác định: Comparator Interface
```
stream3.sorted( (item1, item2) -> {	return item2.compareTo(item1); }
```
* `skip, limit`: skip(), limit() hoàn toàn tương tự với OFSET và LIMIT trong SQL
```
stream4.skip(1).limit(10)
```

### Terminal Operations
* `forEach`: duyệt qua các phần tử của Stream: Comsumer Interface
```
stream5.forEach( item -> {
        	System.out.println(item);
        });
```
* `collect`: thu thập kết quả Stream sang một Collection: Collectors
```
stream6.collect(Collectors.toList())
```
* `reduce`:  kết hợp các phần tử luồng thành một bằng cách sử dụng một BinaryOperator: tham số đứng trước BinaryOperator là identify - phần tử khởi tạo giá trị trả về mặc định nếu stream rỗng. Khi thực hiện `reduce` một stream rỗng mà ko có identify value thì sẽ ném ra Exception
```
stream7.reduce("", (str1, str2) -> str1 + " " + str2)
```
* `count`: trả về tổng số phần tử cho dữ liệu luồng.
``` java
stream7.count();
```

* `max`, `min`: trả về phần tử max hoặc min trong stream: tham số truyền vào là Comparator
``` java
stream7.max( (a, b) -> a - b);
```

* `allMatch` (Predicate) => boolean: kiểm tra xem toàn bộ stream có thỏa mãn điều kiện nào đó ko
``` java
Arrays.asList(1, 2, 3).stream().allMatch( a -> a < 4);   // true
```

* `anyMatch` (Predicate) => boolean: kiểm tra xem trong stream có phần tử nào thỏa mãn điều kiện nào đó ko
``` java
Arrays.asList(1, 2, 3).stream().anyMatch( a -> a < 2);   // true
```

* `noneMatch` (Predicate) => boolean: kiểm tra xem toàn bộ các phần tử nào có không thỏa mãn điều kiện nào đó ko
``` java
Arrays.asList(1, 2, 3).stream().noneMatch( a -> a < 1);   // true
```

* `findAny` trả về 1 Optional của 1 phần tử bất kì trong stream
``` java
Arrays.asList(1, 2, 3).stream().findAny();   // Optional[1]
```

* `findFirst` trả về Optional của phần tử đầu tiên trong stream
``` java
Arrays.asList(1, 2, 3).stream().findFirst();   // Optional[1]
```

## Parallel Stream
``` java
Collection.parallelStream();
```
Kết hợp với xử lí đa luồng, phù hợp với việc xử lí các tập dữ liệu lớn.

--------
<div style="page-break-after: always;"></div>

# 7. Optional
Là đối tượng xử lí các object có khả năng sinh ra NullPointerException: các đối tượng có giá trị là `null`

### Khai báo
``` java
Optional<Object> opt = Optional.empty();                // đối tượng null
Optional<Object> opt = Optional.of(Object);             // đối tượng không null, nếu null ném NullPoiterException
Optional<Object> opt = Optional.ofNullable(Object);     // đối tượng chưa rõ null hay không null
```

### Các method chính
* `opt.orElse(another Object)` : lấy giá trị đối tượng, nếu null lấy giá trị Object truyền vào.
```java
Optional.empty().orElse(null);                  // null
Optional.of(new Integer(1)).orElse(null);       // 1
```

* `opt.orElseThrow(Supplier<X> exceptionSupplier)` : lấy giá trị đối tượng, nếu null ném ra một Exception tùy ý người lập trình.
```java
Optional.empty().orElseThrow( () -> new ArithmeticException);       //  throw ArithmeticException
```

* `opt.get()`: lấy giá trị đối tượng, nếu null ném ra `NoSuchElementException`
```java
Optional.empty().get();                 // Exception
Optional.of(new Integer(1)).get()       // 1
```

* `opt.isPresent()`: check đối tượng có null hay không
```java
Optional.empty().isPresent();           // false
Optional.of(new Integer(1)).isPresent() // true
```
* `opt.ifPresent(Consumer)`: nếu isPresent() thì thực thi phương thức truyền vào
```java
Optional.empty().ifPresent( value -> System.out.println(value));// không in gì
Optional.of(new Integer(1)).isPresent() // true
```
* `opt.filter(Predicate)`: tạo bản sao, lọc bản sao theo một điều kiện nào đó
* `opt.map(Function)`: tạo bản sao, thay đổi bản sao theo một điều kiện nào đó

--------
<div style="page-break-after: always;"></div>

# 8. String
![](https://o7planning.org/vi/10217/cache/images/i/20175.png)

Đối tượng biểu diễn một nối tiếp các kí tự hay 1 mảng kí tự. Vì thế nó là ko thể thay đổi (immutable)

### Khai báo
* `String str = "123"`: String literal. Không khởi tạo Object, lưu giá trị trong Pool. Nếu một string mới đc khai báo mà đã tồn tại trong Pool thì sẽ tham chiếu đến giá trị đã có chứ ko khởi tạo thêm.
* `new String()`: tạo một String Object. Khi đó 2 object đc khởi tạo: một trong Heap Area và một String constant pool. String object sẽ tham chiếu tới object trong heap area

### Các phương thức chính
No | Method | Mô tả
--- | --- | ---
1 | char charAt(int index) | 
2 | int length() |
3 | String substring( int begin, int end) | giống JS
4 | boolean contains(String str) | 
5 | boolean equals(String str) |
6 | boolean isEmpty() |
7 | String replace( char old, char new) |
8 | String[] split(String regex, int limit) | limit là số phần tử tối đa của mảng trả về, nếu là 0 thì ko có  limit
9 | String intern() | trả về chuỗi đc lưu trong Pool
10 | int indexOf( String ch, int fromIndex) |
11 | String toLowerCase() |
12 | String trim() | xóa khoảng trắng ở đầu và cuối chuỗi
13 | static String format(String format, Object... args) | khá giống trong C: `String.format("name is %s", "sonoo");`
14 | static String join(String delimiter, String... args) |
15 | static equalsIgnoreCase(String another) |
16 | static String valueOf( int value) | chuyển int (hoặc kiểu khác) thành String

## StringBuilder và StringBuffer
Chuỗi có thể thay đổi, phù hợp khi làm việc với dữ liệu lớn??
* StringBuilder: xử lí văn bản 1 luồng (Thread)
* StringBuffer: xử lí văn bản nhiều luồng, các method `append`, `insert`, `replace`, `delete`, `reverse` là `synchronized` 

### Các phương thức chính
No | Method | Mô tả
--- | --- | ---
1 | StringBuilder append( String s) | nối chuỗi vào chuỗi ban đầu
2 | StringBuilder insert( int start, String str) | 
3 | StringBuilder replace(int start, int end, String str) | bỏ chuỗi [start,end) thay thế bằng chuỗi str đầy đủ
4 | StringBuilder delete( int start, int end) | 
5 | StringBuilder reverse() | 
6 | int capacity() | trả về dung lượng hiện tại, dung lượng hiện tại >= số kí tự. Nếu append vượt quá dung lượng hiện tại thì dung lượng mới = *2 + 2
7 | void ensureCapacity(int minCapacity) | tăng dung lượng của chuỗi đủ >= minCapacity 

--------
<div style="page-break-after: always;"></div>

# 9. Date
java<8 | java 8
--- | ---
java.util.Date, java.util.Calendar, java.sql.Date | java.time.* : LocalDate, LocalTime, LocalDateTime
không nhất quán khi có 2 class cùng tên Date của gói khác nhau | nhất quán
method `parse, format` trong package java.text | đều trong gói java.time: time.format
mutable, không an toàn trong đa luồng | immutable, thread safe: các hàm modify trả về copy của object gốc nên object gốc không bị thay đổi -> chaining method
thiết kế kém (util.Date gồm cả date và time, sql.Date chỉ gồm date) với các method ko phù hợp với thao tác về ngày tháng?? | chuẩn ISO, nhiều method tiện lợi hơn 
ít hỗ trọ hoặc không có xử lí timezone | hỗ trợ xử lí timezone

### LocalDate
No | Method | Mô tả
--- | --- | ---
1 | static LocalDate now() | `LocalDate.now();`
2 | static LocalDate of(int year, int month, int day) | `LocalDate.of(2019, 12, 26);`
3 | static LocalDate parse(String date, DateTimeFormatter formatter) | `LocalDate.parse("2019-12-26");`
4 | LocalDate plus(long dayToPlus, TemporalUnit unit) | cộng thêm một số đơn vị thời gian (enums) | `LocalDate.now().plus(1, ChronoUnit.MONTHS);`
5 | LocalDate minus(long dayToMinus, TemporalUnit unit) | giảm đi một số đơn vị thời gian (enums) | `LocalDate.now().minus(1, ChronoUnit.MONTHS);`
6 | LocalDate plusDays(long dayToPlus) |
7 | int getDayOfMonth() |
8 | int getYear() |
9 | boolean isLeapYear() |
10 | boolean isAfter(LocalDate anotherLocalDate) |

### LocalTime
No | Method | Mô tả
--- | --- | ---
1 | static LocalTime now() | `LocalTime.now();`
2 | static LocalTime of(int hour, int minute) | `LocalTime.of(12, 26);`
3 | static LocalTime parse(String time, DateTimeFormatter formatter) | `LocalTime.parse("12:26");`
4 | LocalDate plus(long dayToPlus, TemporalUnit unit) | cộng thêm một số đơn vị thời gian (enums) | `LocalDate.now().plus(1, ChronoUnit.MONTHS);`
5 | LocalDate minus(long dayToMinus, TemporalUnit unit) | giảm đi một số đơn vị thời gian (enums) | `LocalDate.now().minus(1, ChronoUnit.MONTHS);`
6 | LocalDate plusDays(long dayToPlus) |
7 | int getDayOfMonth() |
8 | int getYear() |
9 | boolean isLeapYear() |
10 | boolean isAfter(LocalDate anotherLocalDate) |



--------
<div style="page-break-after: always;"></div>


# 10. IO File

--------
<div style="page-break-after: always;"></div>

# 11. Concurrency

