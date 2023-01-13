package com.masai.app.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.exception.FIRException;
import com.masai.app.exception.UserException;
import com.masai.app.model.FIR;
import com.masai.app.model.User;
import com.masai.app.repository.FIRDao;
import com.masai.app.repository.UserDao;

@Service
public class FIRServiceImpl implements FIRService {

	@Autowired
	private UserService userService;

	@Autowired
	private UserDao userDao;

	@Autowired
	private FIRDao firDao;

	@Override
	public FIR fileFIR(String uuid, FIR fir) throws UserException, FIRException {
		User user = userService.getUserByUuid(uuid);
		fir.setUser(user);
		return firDao.save(fir);
	}

	@Override
	public List<FIR> getListOfFIRs(Integer userId) throws UserException, FIRException {
		User user = userDao.findById(userId).orElseThrow(() -> new UserException("User doesn't exists!"));
		if (user.getFirs().isEmpty())
			throw new FIRException("The user haven't filed any FIR yet!");
		return user.getFirs();
	}

	@Override
	public FIR withdrawFIR(String uuid, Integer firId) throws UserException, FIRException {
		User user = userService.getUserByUuid(uuid);
		FIR fir = firDao.findById(firId).orElseThrow(() -> new FIRException("FIR doesn't found!"));
		if (fir.getUser().getId() != user.getId())
			throw new UserException("Access denied!");

		Duration duration = Duration.between(fir.getTimeStamp(), LocalDateTime.now());
		if (duration.toHours() > 24)
			throw new FIRException("FIR filed more than 24 hours ago!");

		firDao.deleteById(firId);
		return fir;
	}

}
