package org.riss.bizconnect.pd.porder.service;

import java.util.ArrayList;
import java.util.Optional;

import org.riss.bizconnect.pd.porder.dto.PorderDTO;

public interface PorderService {
	ArrayList<PorderDTO> listAllPorders();
	Optional<PorderDTO> selectPorderNo(int PorderNo);
	void insertPorder(PorderDTO porder);
	void updatePorder(PorderDTO porder);
	void deletePorder(int porderNo);
	/*ArrayList<PorderDTO> selectList();*/

	
}
