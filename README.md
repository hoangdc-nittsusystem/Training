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
Đối tượng xử lí tập hợp các object, có thể là Collection, Array hoặc I/O File. Cung cấp một số phương thức thao tác tuần tự trên các tập hợp để đạt đc kết quả mong muốn.

Đặc điểm:
* Không lưu trữ dữ liệu mà thao tác trên dữ liệu lấy từ nguồn
* Không thay đổi dữ liệu gốc
* Nếu có 1 thao tác đầu cuối được thực hiện trên 1 stream thì stream này ko duyệt đc mặc dù địa chỉ trên bộ nhớ ko đổi. Muốn duyệt ta phải tạo lại một stream mới.

Sử dụng:
* Tạo stream (stream source)
* Thực hiện thao tác trung gian (Intermediate Operations): `map`, `filter`, `sorted`
* Thực hiện thao tác đầu cuối (Terminal Operations) để trả về kết quả cuối cùng của loạt thao tác trên dữ liệu: `collect`, `forEach`, `reduce`

Nguồn lấy stream:
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
* `ship, limit`: skip(), limit() hoàn toàn tương tự với OFSET và LIMIT trong SQL
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
Optional<Object> opt = Optional.empty();    // đối tượng null
Optional<Object> opt = Optional.of(Object); // đối tượng không null
Optional<Object> opt = Optional.ofNullable; // đối tượng chưa rõ null hay không null
```

### Các method chính
* orElse()
* get()
* isPresent()

--------
<div style="page-break-after: always;"></div>

# 8. String

--------
<div style="page-break-after: always;"></div>

# 7. Date

--------
<div style="page-break-after: always;"></div>


# 8. IO File

--------
<div style="page-break-after: always;"></div>

# 9. Concurrency

