package org.myweb.first.board.model.service;

import java.util.ArrayList;

import org.myweb.first.board.model.dto.Board;
import org.springframework.beans.factory.annotation.Autowired;

public interface BoardService {
	ArrayList<Board> selectTop3();
}
