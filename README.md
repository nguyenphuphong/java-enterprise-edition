# SENIOR

Đối với môn học này chúng ta cùng giả định rằng SENIOR là cũng là một hệ thống quản lý trường học,
về cơ bản thì nó sẻ có các chức năng tương tự như các chức năng của hệ thống JUNIOR, ngoài ra SENIOR
sẻ cung cấp thêm một số tính năng riêng mà hệ thống JUNIOR không có. Để dể hình dung chúng ta sẻ có
các bài tập xoay quanh việc mở rộng tính năng của SENIOR và JUNIOR. Hãy xem như JUNIOR là một hệ
thống quản lý một trường cấp 2, còn SENIOR là một hệ thống quản lý trường cấp 3. Những bài học và
bài tập trong môn này sẻ xoay quanh vấn đề, khi các bạn học sinh cấp 2 tốt nghiệp, thì học sinh sẻ
tìm kiếm cho mình một cơ hội để vào trường cấp 3 (trường dân lập, trường công, trường chuyên)...

## Bài tập 1

Trong bài tập này chúng ta sẻ làm quen với việc sử dụng JSF (Java Server Faces).

Nhiệm vụ của bài tập này là tạo ra một trang để quản lý việc tạo ra thông tin tuyển sinh trên hệ thống
SENIOR. Chúng ta gọi nó là (application.xhtml) và (application-detail.xhtml). Chúng ta giả sử rằng việc
tuyển sinh sẻ sử dụng tổ hợp điểm của của các môn (Toán, Văn, Anh Văn, Lý, Hóa, Sinh, Sử, Địa), hệ số
điểm của các môn là hệ số 10 (thấp nhất là 0 điểm, cao nhất là 10 điểm)

Trang (application.xhtml) là trang danh sách các thông tin tuyển sinh của hệ thống SENIOR, trang
(application-detail.xhtml) là nội dung chi tiết của một thông tin tuyển sinh.

Thiết lập cơ bản của 1 thông tin tuyển sinh (application) là như sau.

- (title): Tiêu đề tuyển sinh
- (content): Nội dung tuyển sinh
- (min_mathematics): Điểm tối thiểu môn Toán
- (min_literature): Điểm tối thiểu môn Văn
- (min_english): Điểm tối thiểu môn Tiếng Anh
- (min_physics): Điểm tối thiểu môn Vật Lý
- (min_chemistry): Điểm tối thiểu môn Hóa
- (min_biological): Điểm tối thiểu môn Sinh
- (min_history): Điểm tối thiểu môn Sử
- (min_geography): Điểm tối thiểu môn Địa
- (created_date): Ngày tạo thông tin tuyển sinh
- (updated_date): Ngày chỉnh sửa thông tin
- (due_date): Ngày hết hạn tuyển sinh

Một thông tin tuyển sinh mà đã hết hạn tuyển sinh thì không thể chỉnh sửa được nữa.

Khi vào trang (application-detail.xhtml) chúng ta sẻ xem, chỉnh sửa được các thông tin tuyển sinh, cũng như
thấy được một danh sách các học sinh đã nộp đơn dự tuyển trong hệ thống SENIOR.

Không thể chỉnh sửa thông tin dự tuyển của học sinh.

Thông tin dự tuyển của học sinh cơ bản như sau:
- (email): Địa chỉ email của học sinh
- (full_name): Họ và tên của học sinh
- (dob): Ngày tháng năm sinh của học sinh
- (address): Địa chỉ của học sinh
- (school): Trường cấp 2 học sinh theo học
- (mathematics): Điểm Toán của học sinh
- (literature): Điểm Văn của học sinh
- (enghlish): Điểm Tiếng Anh của học sinh
- (physics): Điểm Lý của học sinh
- (chemistry): Điểm Hóa của học sinh
- (biological): Điểm Sinh của học sinh
- (history): Điểm Sử của học sinh
- (geography): Điểm Địa cuả học sinh

## Bài tập 2

Trong bài này chúng ta sẻ làm quen với JPA (Java Persistence API)

Sau khi thiết lập các trang JSF cơ bản, chúng ta sẻ quan tâm tới việc kết nối với hệ thống dữ liệu, giống JUNIOR,
SENIOR cũng sẻ sữ dụng hệ thống cơ sở dữ liệu H2. Chúng ta cũng sẻ cần quan tâm tới việc phân quyền.

Tiếp tục với bài tập 1, bây giờ chúng ta sẻ thay thế các dữ liệu tĩnh trong JSF pages (application.xhtml, application-
detail.xhtml) bằng các dữ liệu trong hệ thống cơ sở dữ liệu.

Trong bài tập này chúng ta sẻ thêm tính năng cho việc xét tuyển sinh, chúng ta đã có các điểm tối thiểu để tuyển chọn
học sinh, bây giờ chúng ta sẻ thêm các mốc điểm mới để xét việc tuyển thẳng một học sinh mà không cần qua thi cữ. Hãy
giả sữ rằng một trường có thể cùng lúc đưa ra nhiều thông tin tuyển sinh cùng một lúc. Ví dụ 1 trường chuyên cấp 3
thường đưa ra 2 thông tin tuyển sinh cho lớp 10, 1 thông tin cho hệ chuyên, 1 thông tin cho hệ phổ thông. Bình thường
thông tin tuyển sinh hệ chuyên sẻ luôn yêu cầu các bạn đạt đủ điểm tiêu chuẩn sẻ trải qua một kì thi riêng để vào lớp
chuyên trừ một số bạn đạt học sinh giỏi cấp tỉnh - quốc gia lúc học cấp 2 sẻ được tuyển thẳng vào lớp chuyên, còn đối
với tuyển sinh hệ phổ thông chỉ cần đủ điểm là có thể được xét duyệt tuyển sinh.

Với các bạn đăng tuyển vào lớp chuyên, tùy theo từng lớp chuyên mà các bạn phải thi thêm môn chuyên tương ứng đó.
Ví dụ: Học sinh đăng kí thi vào lớp chuyên Toán sẻ phải thi đầu vào môn Toán, Học sinh đăng kí thi vào lớp chuyên Sử
sẻ thi đầu vào môn Sử.

Ngoài các thông tin tuyển sinh cho các lớp chuyên và đại trà, ngày nay chúng ta thấy các trường cấp 3 sẻ tuyển sinh theo
khối thi đại học ngay từ năm lớp 10 các bạn học sinh đã đăng kí nguyện vọng học chương trình theo khối. Vì vậy, hệ thống
SENIOR cũng số hóa tính năng này.

Như vậy chúng ta cơ bản sẻ có các bảng tương ứng như sau

(tb_application)

- (id): Khóa chính của bảng, tự tăng theo (sq_application)
- (title): Tiêu đề tuyển sinh
- (content): Nội dung tuyển sinh
- (min_mathematics): Điểm tối thiểu môn Toán
- (min_literature): Điểm tối thiểu môn Văn
- (min_english): Điểm tối thiểu môn Tiếng Anh
- (min_physics): Điểm tối thiểu môn Vật Lý
- (min_chemistry): Điểm tối thiểu môn Hóa
- (min_biological): Điểm tối thiểu môn Sinh
- (min_history): Điểm tối thiểu môn Sử
- (min_geography): Điểm tối thiểu môn Địa
- (created_date): Ngày tạo thông tin tuyển sinh
- (updated_date): Ngày chỉnh sửa thông tin
- (due_date): Ngày hết hạn tuyển sinh
- (has_extra_exam): Cờ để thông báo rằng thông tin dự tuyển này cần phải tổ chức một kì thi riêng, sau khi thõa mãn yêu cầu dự tuyển.
Điểm (min) trong khối dự tuyển này không được bé hơn điểm (min) tưng ứng bên trường liên kết. Ví dụ: Điểm tối thiểu Toán của khối cơ
bản là 7đ, thì điểm tối thiểu của khối chuyên Vật Lý phải từ 7đ trở lên.
- (application_id): khóa ngoại tới bảng (tb_application), đại diện cho vai trò tuyển sinh từng khối.

Bảng (tb_application) chứa thông tin cơ bản cho từng khối tuyển sinh, khi khối tuyển sinh cơ bản thì (application_id) sẻ null,
ý nghĩa là đây là số điểm thấp nhất học sinh dự tuyển phải đạt được nếu muốn tuyển sinh vào trường. Nhưng dữ liệu mà
(application_id) khác null, có nghĩa là thông tin tuyển sinh đó liên quan tới thông sinh tuyển sinh trước nó, ví dụ tuyển sinh
chuyên Toán, thì về cơ bản học sinh này đã phải thõa mãn yêu cầu cơ bản rồi sau đó phải đạt thêm yêu cầu của tuyển
sinh chuyên Toán.

(tb_student)

- (id): khóa chính của bảng, tự tăng theo (sq_application_student)
- (email): Địa chỉ email của học sinh, là duy nhất trong bảng.
- (full_name): Họ và tên của học sinh
- (dob): Ngày tháng năm sinh của học sinh
- (address): Địa chỉ của học sinh
- (school): Trường cấp 2 học sinh theo học
- (mathematics): Điểm Toán của học sinh
- (literature): Điểm Văn của học sinh
- (enghlish): Điểm Tiếng Anh của học sinh
- (physics): Điểm Lý của học sinh
- (chemistry): Điểm Hóa của học sinh
- (biological): Điểm Sinh của học sinh
- (history): Điểm Sử của học sinh
- (geography): Điểm Địa cuả học sinh
- (created_date): Ngày tạo thông tin học sinh
- (updated_date): Ngày chỉnh sửa thông tin học sinh

Bảng (tb_student) chứa thông tin học sinh dự tuyển tương ứng. Một học sinh có thể dự tuyển và nhiều khối khác nhau,
ví dụ: học sinh A có thể dự tuyển cả và khối chuyên, đại trà, khối tự nhiên, khối xã hội, ... Nhưng học sinh đó chỉ có thể
trúng tuyển vào 1 khối duy nhất.

(tb_application_student)

- (application_id): khóa ngoại tới bảng (tb_application)
- (student_id): khóa ngoại tới bảng (tb_student)

Bảng (tb_application_student) chứa thông tin đăng kí khối của học sinh, học sinh có thể đăng kí nhiều khối cùng 1 lúc.

Về phân quyền, tất cả các quyền tạo, chỉnh sữa, xóa thông tin tuyển sinh đều chỉ có thể được thực hiện bởi (warden) quản giáo.

