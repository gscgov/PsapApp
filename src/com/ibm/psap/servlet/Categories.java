package com.ibm.psap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONObject; 

import com.ibm.psap.util.Constants;
import com.ibm.psap.util.DBResultSetToJson;

/**
 * Servlet implementation class Categories
 */
@WebServlet("/Categories")
public class Categories extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(Categories.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Categories() {
        super();
        // TODO Auto-generated constructor stub
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String categorytype = request.getParameter("type");
		JSONObject jsonResponse =  null;
		boolean productionMode =(boolean)getServletContext().getAttribute("productionMode");
		logger.info("The requested type is "+categorytype);
		if (categorytype!= null){
			String jsonString = null;
			switch (categorytype){
				case "CATEGORY":
					if (productionMode){
						//extarct from the data set
					}else{
						//stub
						jsonString = Constants.CATEGORY_JSONSTR;
					}
					break;
				case "SOLUTION":
					if (productionMode){
						//extarct from the data set
					}else{
						//stub
						jsonString = Constants.SOLUTION_JSONSTR;
					}
					break;
				case "OFFERING":
					if (productionMode){
						//extarct from the data set
					}else{
						//stub
						jsonString = Constants.OFFERING_JSONSTR;
					}
					break;	
				default:
					break;
			}
			try {
				jsonResponse = DBResultSetToJson.convertStringToJSONArray(jsonString);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new IOException(e.getMessage());
			}
		}
		logger.info("Returning the response to request type "+categorytype);
		logger.info("Response to request is "+jsonResponse.toString());
		response.setContentType("application/json");
		response.getWriter().write(jsonResponse.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}