package com.masai.app.service;

import java.util.List;

import com.masai.app.exception.FIRException;
import com.masai.app.exception.UserException;
import com.masai.app.model.FIR;

public interface FIRService {

	FIR fileFIR(String uuid, FIR fir) throws UserException, FIRException;

	List<FIR> getListOfFIRs(Integer userId) throws UserException, FIRException;

	FIR withdrawFIR(String uuid, Integer firId) throws UserException, FIRException;

}
