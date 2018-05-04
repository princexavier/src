package com.sai.lendperfect.application.courseexpense;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.lendperfect.application.model.LpcustApplicantEduCourseExp;
import com.sai.lendperfect.application.repo.LpCourseExpenseRepo;
import com.sai.lendperfect.commodel.LpcomProposal;
import com.sai.lendperfect.setupmodel.LpstpCMAMaster;


@Service("LpcomCourseExpenseService")
@Transactional
public class LpcomCourseExpenseServiceImpl implements LpcomCourseExpenseService{
   
	@Autowired
	LpCourseExpenseRepo lpCourseExpenseRepo;
	
	@Override
	public List<LpcustApplicantEduCourseExp> findByLpcomProposal(LpcomProposal lpcomProposal) {
		// TODO Auto-generated method stub
		return lpCourseExpenseRepo.findByLpcomProposal( lpcomProposal);
	}

	@Override
	public List<LpcustApplicantEduCourseExp> save(List<LpcustApplicantEduCourseExp> lpcustApplicantEduCourseExpList) {
		// TODO Auto-generated method stub
		return lpCourseExpenseRepo.save(lpcustApplicantEduCourseExpList);
	}

	@Override
	public List<LpcustApplicantEduCourseExp> findAllByLpcomProposal(LpcomProposal lpcomProposal) {
		// TODO Auto-generated method stub
		return lpCourseExpenseRepo.findAllByLpcomProposal( lpcomProposal) ;
	}

	
	
}
