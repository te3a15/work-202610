package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   // リクエストパラメータを取得
   request.setCharacterEncoding("UTF-8");
   String name = request.getParameter("name");
   String plan = request.getParameter("plan");
   // リクエストパラメータをチェック
   String errorMsg = "";
   if (name == null || name.length() == 0) {
     errorMsg += "名前が入力されていません<br>";
   }
   if (plan == null || plan.length() == 0) {
     errorMsg += "会員種別が選択されていません<br>";
   } else {
     if (plan.equals("regular")) { plan = "一般会員"; }
     else if (plan.equals("premium")) { plan = "プレミアム会員"; }
   }
   // 表示するメッセージを設定
   String msg = name + "さん（" + plan + "）を登録しました";
   if (errorMsg.length() != 0) {
     msg = errorMsg;
   }
   // HTMLを出力
   response.setContentType("text/html; charset=UTF-8");
   PrintWriter out = response.getWriter();
   out.println("<!DOCTYPE html >");
   out.println("<html>");
   out.println("<head>");
   out.println("<meta charset=\"UTF-8\">");
   out.println("<title>ユーザー登録結果</title>");
   out.println("</head>");
   out.println("<body>");
   out.println("<p>" + msg + "</p>");
   out.println("</body>");
   out.println("</html>");
 }
}
