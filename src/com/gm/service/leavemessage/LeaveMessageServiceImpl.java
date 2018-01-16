package com.gm.service.leavemessage;

import java.util.List;

import javax.annotation.Resource;

import com.gm.dao.leavemessage.LeaveMessageMapper;
import com.gm.pojo.LeaveMessage;
import org.springframework.stereotype.Service;

@Service
public class LeaveMessageServiceImpl implements LeaveMessageService{
	
	@Resource
	private LeaveMessageMapper mapper;
	
	public List<LeaveMessage> getLeaveMessageList(LeaveMessage leaveMessage)
			throws Exception {
		// TODO Auto-generated method stub
		return mapper.getLeaveMessageList(leaveMessage);
	}

	public int count(LeaveMessage leaveMessage) throws Exception {
		// TODO Auto-generated method stub
		return mapper.count(leaveMessage);
	}

	public int addLeaveMessage(LeaveMessage leaveMessage) throws Exception {
		// TODO Auto-generated method stub
		return mapper.addLeaveMessage(leaveMessage);
	}

	public int modifyLeaveMessage(LeaveMessage leaveMessage) {
		// TODO Auto-generated method stub
		return mapper.modifyLeaveMessage(leaveMessage);
	}

	public int deleteLeaveMessage(LeaveMessage deleteLeaveMessage) {
		// TODO Auto-generated method stub
		return mapper.deleteLeaveMessage(deleteLeaveMessage);
	}

	public LeaveMessage getLeaveMessage(LeaveMessage leaveMessage)
			throws Exception {
		// TODO Auto-generated method stub
		return mapper.getLeaveMessage(leaveMessage);
	}

}
