package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dto.MovieDTO;


@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson g = new Gson();
		String cmd = request.getRequestURI();
		
		if(cmd.equals("/exam01.ajax")) {
			System.out.println("단순 요청 확인");
		}else if(cmd.equals("/exam02.ajax")) {
			String param1 = request.getParameter("key1");
			String param2 = request.getParameter("key2");
			
			System.out.println(param1 + ": " + param2);
		}else if(cmd.equals("/exam03.ajax")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter pw = response.getWriter();
			pw.append("AJAX 응답 데이터 입니다. ");
			
		}else if(cmd.equals("/exam04.ajax")) {
			response.setContentType("text/html; charset=UTF-8");
			
			String[] fruits = new String[] {"Orange", "Mango","Apple"};		
			PrintWriter pw = response.getWriter();
			
			
			String result = g.toJson(fruits);
			
			
			pw.append(result);
			// 직렬화 해서 보낸 후 역 직렬화 해서 사용
			
		}else if (cmd.equals("/exam05.ajax")) {
			response.setContentType("text/html; charset=UTF-8");
			
			MovieDTO dto = new MovieDTO(1001,"범죄도시4","액션");
			
			String result = g.toJson(dto);
			
			PrintWriter pw = response.getWriter();
			pw.append(result);
		}else if(cmd.equals("/exam06.ajax")) {
			   response.setContentType("text/html; charset=UTF-8");

			    List<MovieDTO> list = new ArrayList<>();
			    list.add(new MovieDTO(1001,"범죄도시4","액션"));
			    list.add(new MovieDTO(1002,"범죄도시5","코미디"));
			    list.add(new MovieDTO(1003,"범죄도시6","로맨스"));

			    String result = g.toJson(list);
			    PrintWriter pw = response.getWriter();
			    pw.append(result);
		}else if(cmd.equals("/exam07.ajax")) {
			response.setContentType("text/html; charset=UTF-8");
			JsonObject obj = new JsonObject(); // "{ }"
			obj.addProperty("fruits", "Apple");
			obj.addProperty("title", "범죄도시4");
			
			JsonArray arr = new JsonArray(); // "[ ]"
			PrintWriter pw = response.getWriter();
			pw.append(obj.toString());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
