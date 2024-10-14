package org.riss.bizconnect.pd.check.model.service;

import java.util.ArrayList;
import java.util.Optional;

import org.riss.bizconnect.pd.check.model.dto.CheckDTO;

public interface CheckService {
	ArrayList<CheckDTO> listAllChecks();
	Optional<CheckDTO> selectorderNo(String OrderNo);
}
