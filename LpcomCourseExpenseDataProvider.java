package com.sai.lendperfect.application.courseexpense;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sai.lendperfect.application.util.CustomErr;
import com.sai.lendperfect.application.util.ErrConstants;
import com.sai.lendperfect.application.util.Helper;
import com.sai.lendperfect.application.util.ServiceProvider;
import com.sai.lendperfect.application.model.LpcustApplicantEduCourseExp;
import com.sai.lendperfect.commodel.LpcomProposal;
import com.sai.lendperfect.logging.Logging;

public class LpcomCourseExpenseDataProvider {
	public Map<String, ?> getData(String dpMethod, HttpSession session, Map<?, ?> allRequestParams, Object masterData,ServiceProvider serviceProvider, Logging logging) {
		logging.setLoggerClass(this.getClass());
		Map<String, Object> responseHashMap = new HashMap<String, Object>();
		Map<String, Object> dataHashMap = new HashMap<String, Object>();
		
         session.setAttribute("LP_COM_PROP_NO", "123450000000013");
		
		Map <String,Object> requestHashMap=new HashMap<String,Object>();
		long proposalNoValue = Long.parseLong(session.getAttribute("LP_COM_PROP_NO").toString());
//		LpcomProposal lpcomProposal = serviceProvider.getLpcomProposalService().findByLpPropNo(new BigDecimal(proposalNoValue));
	    try{
	    	
	    	if(dpMethod.equals("saveDetails")){
	    		
	    		try{
	    			 
	    			
	    	  		
		    		List<Map<String,Object>> lpcustApplicantEduCourseExpMapList= (List<Map<String,Object>>) allRequestParams.get("requestData");
					List<LpcustApplicantEduCourseExp> lpcustApplicantEduCourseExpList=new ArrayList<LpcustApplicantEduCourseExp>();
					Iterator<Map<String,Object>> lpcustApplicantEduCourseExpMapListItr=lpcustApplicantEduCourseExpMapList.iterator();
					while(lpcustApplicantEduCourseExpMapListItr.hasNext()){
						Map <String,Object> lpcustApplicantEduCourseExpMap=lpcustApplicantEduCourseExpMapListItr.next();
						LpcustApplicantEduCourseExp  lpcustApplicantEduCourseExp=new ObjectMapper().convertValue(lpcustApplicantEduCourseExpMap, LpcustApplicantEduCourseExp.class);
						lpcustApplicantEduCourseExp.setLpcomProposal(serviceProvider.getLpcomProposalService().findByLpPropNo(new BigDecimal(session.getAttribute("LP_COM_PROP_NO").toString())));
						lpcustApplicantEduCourseExpList.add(lpcustApplicantEduCourseExp);
						lpcustApplicantEduCourseExp.setLaecCreatedby("prince");
						lpcustApplicantEduCourseExp.setLaecCreateddate(Helper.getSystemDate());	
						lpcustApplicantEduCourseExp.setLaecModifieddby("prince");
						lpcustApplicantEduCourseExp.setLaecModifieddate(Helper.getSystemDate());	

					}
					
					
					serviceProvider.getLpcomCourseExpenseService().save(lpcustApplicantEduCourseExpList);
					
					dataHashMap.put("success",true);
					dataHashMap.put("lpcustApplicantEduCourseExpList",lpcustApplicantEduCourseExpList);
					responseHashMap.put("responseData", dataHashMap);
	    			
	    		}
	    		catch(Exception e){
	    			logging.error("Provider : {} , Method : {} , ErrorMessage : {}", this.getClass().getName(), dpMethod,e.getCause().getMessage());
					dataHashMap.put("errorData",new CustomErr(ErrConstants.invalidDataErrCode, ErrConstants.invalidDataErrMessage));
					responseHashMap.put("success", false);
					responseHashMap.put("responseData", dataHashMap);
	    		}
	  
			
			
	    }
	    	
	    	else	if(dpMethod.equals("getdetails")){
	    		
	    		
	    		try{
	    			
	    			LpcomProposal lpcomProposal = serviceProvider.getLpcomProposalService().findByLpPropNo(new BigDecimal( session.getAttribute("LP_COM_PROP_NO").toString()));
	    			
	    			List<LpcustApplicantEduCourseExp>lpcustApplicantEduCourseExpList = serviceProvider.getLpcomCourseExpenseService().findByLpcomProposal(lpcomProposal);
	    			List<Map<String,Object>>lpcustApplicantEduCourseExpListg = new ArrayList<Map<String,Object>>();

					dataHashMap.put("alldetails",serviceProvider.getLpcomCourseExpenseService().findAllByLpcomProposal(lpcomProposal));
	    			responseHashMap.put("success", true);
                   responseHashMap.put("responseData", dataHashMap)	;    			
	    		}
	    		catch(Exception e){
	    			logging.error("Provider : {} , Method : {} , ErrorMessage : {}", this.getClass().getName(), dpMethod,e.getCause().getMessage());
					dataHashMap.put("errorData",new CustomErr(ErrConstants.invalidDataErrCode, ErrConstants.invalidDataErrMessage));
					responseHashMap.put("success", false);
					responseHashMap.put("responseData", dataHashMap);
	    		}
	    	}
	    	
	    }
	    
	    catch(Exception e ){
	    	
			
				dataHashMap.put("errorData",new CustomErr(ErrConstants.invalidDataErrCode, ErrConstants.invalidDataErrMessage));
				responseHashMap.put("success", false);
				responseHashMap.put("responseData", dataHashMap);
			
	    }
		return responseHashMap;
	}
}
