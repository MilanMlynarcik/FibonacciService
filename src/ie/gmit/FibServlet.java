package ie.gmit;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.*;

public class FibServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 777L;

	public FibServlet() {
		super();
		TimerClass.getInstance();

		// TODO Auto-generated constructor stub
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Gson gson = new Gson();

		int max = Integer.valueOf(request.getParameter("max"));
		int jobNum = Integer.valueOf(request.getParameter("jobNum"));

		String[] responseArray = new String[] { "", "" };

		response.setContentType("application/json"); // Set content type of the
														// response so that
														// jQuery knows what it
														// can expect.

		if (jobNum == 0) {

			int jNum = FibService.add(max);
			responseArray[0] = "0";
			responseArray[1] = String.valueOf(jNum);
			String json = gson.toJson(responseArray);
			response.getWriter().write(json);
		}

		else {

			String result = null;
			FibService client = new FibService();
			result = client.getRequest(jobNum);

			if (result != null) {

				responseArray[0] = result;
				responseArray[1] = String.valueOf(jobNum);
				String json = gson.toJson(responseArray);
				response.getWriter().write(json);
			} else {

				responseArray[0] = "0";
				responseArray[1] = String.valueOf(jobNum);
				String json = gson.toJson(responseArray);
				response.getWriter().write(json);
			}

		}
	}

	public void init() throws ServletException {
		FibonacciClient.setHostName(getServletContext().getInitParameter("hostname"));
		FibonacciClient.setPort(getServletContext().getInitParameter("port"));
		FibonacciClient.setObjectname(getServletContext().getInitParameter("objectname"));
		FibonacciClient.setRmi(getServletContext().getInitParameter("rmi"));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
