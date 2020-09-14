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

