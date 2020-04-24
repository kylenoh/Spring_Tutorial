package kr.co.board.entity;

import java.util.Date;

public class Board {
	private int TB_IDX;
	private String TB_TITLE;
	private String TB_CONTENTS;
	private int TB_CONTENT_CNT;
	private char TB_DEL_GB;
	private Date TB_WRITE_DTM;
	private String TB_WRITE_ID;
	
	public Board() {

	}

	public Board(int tB_IDX, String tB_TITLE, String tB_CONTENTS, int tB_CONTENT_CNT, char tB_DEL_GB, Date tB_WRITE_DTM,
			String tB_WRITE_ID) {
		super();
		TB_IDX = tB_IDX;
		TB_TITLE = tB_TITLE;
		TB_CONTENTS = tB_CONTENTS;
		TB_CONTENT_CNT = tB_CONTENT_CNT;
		TB_DEL_GB = tB_DEL_GB;
		TB_WRITE_DTM = tB_WRITE_DTM;
		TB_WRITE_ID = tB_WRITE_ID;
	}

	public int getTB_IDX() {
		return TB_IDX;
	}

	public void setTB_IDX(int tB_IDX) {
		TB_IDX = tB_IDX;
	}

	public String getTB_TITLE() {
		return TB_TITLE;
	}

	public void setTB_TITLE(String tB_TITLE) {
		TB_TITLE = tB_TITLE;
	}

	public String getTB_CONTENTS() {
		return TB_CONTENTS;
	}

	public void setTB_CONTENTS(String tB_CONTENTS) {
		TB_CONTENTS = tB_CONTENTS;
	}

	public int getTB_CONTENT_CNT() {
		return TB_CONTENT_CNT;
	}

	public void setTB_CONTENT_CNT(int tB_CONTENT_CNT) {
		TB_CONTENT_CNT = tB_CONTENT_CNT;
	}

	public char getTB_DEL_GB() {
		return TB_DEL_GB;
	}

	public void setTB_DEL_GB(char tB_DEL_GB) {
		TB_DEL_GB = tB_DEL_GB;
	}

	public Date getTB_WRITE_DTM() {
		return TB_WRITE_DTM;
	}

	public void setTB_WRITE_DTM(Date tB_WRITE_DTM) {
		TB_WRITE_DTM = tB_WRITE_DTM;
	}

	public String getTB_WRITE_ID() {
		return TB_WRITE_ID;
	}

	public void setTB_WRITE_ID(String tB_WRITE_ID) {
		TB_WRITE_ID = tB_WRITE_ID;
	}
	
	
	
}
