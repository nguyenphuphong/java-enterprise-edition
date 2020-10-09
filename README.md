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

## Bài tập 3

Trong bài tập này chúng ta sẻ làm quen với việc sử dụng EJB (Enterprise Java Beans).

Tiếp tục với 2 bài tập trước, bài tập này sẻ cung cấp thêm tính năng cho hệ thống SENIOR. Hiện tại qua môn trước và tới bây giờ
mỗi ứng dụng thường đơn lẽ, mỗi hệ thống cũng đơn lẽ, nhưng trên thực tế, việc một ứng dụng, hay hệ thống chỉ hoạt động đơn lẽ
là rất hạn chế, vì thế nhu cầu rất lớn đặt vào tính liên kết của các ứng dụng và hệ thống với nhau.

Trong bài tập này chúng ta sẻ kết nối ứng dụng JUNIOR với hệ thống SENIOR như sau. Chúng ta quay lại với nhu cầu tuyển sinh, và
dự tuyển của học sinh với trường cấp 3. Chúng ta xây dựng được một cơ sở dữ liệu cho việc đưa thông tin tuyển dụng, lưu trữ
những đơn dự tuyển của học sinh, nhưng chúng ta cần tạo một nơi mà học sinh có thể dự tuyển.

Trước hết, yêu cầu đầu tiên của bài tập này là trên hệ thống SENIOR tạo ra một page cho phép student có thể dự tuyển vào
bất kì khối nào mà SENIOR đang đăng tin tuyển sinh. Cho nên chúng ta cần có 1 page mới cho việc đó, gọi là (application-registration.xhtml)
Trang này không có phân quyền, vì các bạn học sinh thường không phải là người của hệ thống SENIOR.

Trang (application-registration.xhmtl) cho phép nhập các thông tin của học sinh:

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

Ngoài ra trên trang này, học sinh còn có thể chọn một danh sách các (application) mà SENIOR đang có. Qua đó học sinh dự tuyển có thể chọn
các khối dự tuyển tương ứng. Chính về hệ thống không phân quyền của của trang này, nên hệ thống phải kiểm tra tính duy nhất của (email)
để xác định xem học sinh này đã đăng kí dự tuyển hay chưa. Nếu đã đăng kí dự tuyển thì chúng ta sẻ hiễn thị lại các thông tin mà học sinh
đó đã đăng kí. Qua đó học sinh này có thể chỉnh sữa lại thông tin đăng kí (trong bài tập này chúng ta không quan tâm tới vấn đề bảo mật
thông tin dự tuyển của học sinh)

Yêu cầu thứ hai của bài tập này là liên kết hệ thống JUNIOR với hệ thống SENIOR, theo đó học sinh đăng nhập vào hệ thống JUNIOR sẻ có thể
trực tiếp nộp đơn dự tuyển vào hệ thống SENIOR từ ứng dụng JUNIOR. Việc này đòi hỏi chúng ta cần phải sử dụng EJB. Bên hệ thống SENIOR
chúng ta cần expose 1 stateless EJB gọi là (ApplicationStatelessBean.java). Stateless Bean này cho phép học sinh đăng kí dự tuyển, thông tin
đăng kí giống với những gì chúng ta làm với yêu cầu 1. Vì vậy, sẻ tốt nhất nếu hệ thống SENIOR sử dụng luôn EJB này cho tính năng thứ nhất.

Bên hệ thống JUNIOR, chúng ta cần tạo ra một bảng điểm cho học sinh, sau khi học sinh đăng nhập vào hệ thống JUNIOR, sẻ có một đường dẫn mới,
mỡ ra một trang hiễn thị các thông tin dự tuyển, trên trang này học sinh có thể chọn một danh sách các thông tin dự tuyển sau đó yêu cầu đăng
kí này sẻ được hệ thống JUNIOR liên kết với hệ thống SENIOR để thực hiện. Sử dụng tính năng liên kết này, học sinh không cần phải nhập điểm
môn học, tại vì cơ bản hệ thống JUNIOR đã quản lí điểm cho học sinh đó rồi, nên khi xử lý yêu cầu dự tuyển, hệ thống JUNIOR sẻ tự động chuyển
tiếp bảng điểm của học sinh lên thông tin dự tuyển cho học sinh đấy.

## Bài tập 4

Trong bài tập này chúng ta sẻ làm quen với việc sử dụng Mesage Brokers.

Chúng ta sẻ tiếp tục bổ sung thêm tính năng cho hệ thống SENIOR trong qui trình tuyển sinh như sau. Tính năng cần thêm vào đó là,
giáo vụ (warden) có thể đánh giấu một học sinh nào đấy là trúng tuyển trực tiếp, ví dụ: học sinh này đạt giải cao trong kì thi học sinh
giỏi cấp thành phố chẳng hạn. Hoặc học bạ của bạn này có số điểm rất cao chẳng hạn.

Như vậy chúng ta cần edit bảng (tb_application_student) để phục vụ cho việc đấy:

(tb_application_student)

- (application_id): khóa ngoại tới bảng (tb_application)
- (student_id): khóa ngoại tới bảng (tb_student)
- (passed): cờ để xác định học sinh này có trúng tuyển khối đăng kí hay không.
- (reason): mô tả lý do trúng tuyển - điểm cao, học sinh giỏi cấp thành phố, con em dân tộc thiểu số ...

Giáo vụ có thể đánh dấu một học sinh được trúng tuyển trong hệ thống SENIOR, tính năng này có thể được thực hiện trong trang (application-detail.xhtml)

Tiếp theo, chúng ta cần thực hiện một tính năng liên kết. Tính năng liên kết này giúp hệ thống SENIOR có thể thông báo cho hệ thống JUNIOR biết
được rằng một học sinh của họ - JUNIOR đã trúng tuyển vào trường cấp 3 - SENIOR đấy. Để làm được tính năng này chúng ta cần dùng tới Message Broker
theo đó, sau khi giáo vụ đánh dấu rằng một học sinh đã được trúng tuyển trực tiếp trong hệ thống SENIOR sẻ xuất ra một thông báo thông qua Message Broker.
Bên hệ thống JUNIOR sẻ lắng nghe thông báo này, và ghi lại thông tín đó trong cơ sở dữ liệu của JUNIOR.

Khi học sinh đăng nhập vào hệ thống JUNIOR, sẻ có một đường dẫn hiện thị kết quả mà hệ thống đã ghi nhận thống báo từ SENIOR trước đó.

