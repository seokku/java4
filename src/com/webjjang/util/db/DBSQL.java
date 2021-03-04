package com.webjjang.util.db;

public class DBSQL {

	// 게시판 쿼리 --------------------------------------------------------------
	// 게시판 리스트
	public static final String BOARD_LIST 
	= "select rnum, no, title, writer,"
	+ " to_char(writeDate, 'yyyy.mm.dd') writeDate, hit from( "
		+ " select rownum rnum, no, title, writer, writeDate, hit from ("
			+ " select no, title, writer, writeDate, hit from board"
			+ " order by no desc "
		+ " ) "
	+ ") where rnum between ? and ?  ";
	public static final String BOARD_VIEW 
	= " select no, title, content, writer, "
	+ " to_char(writeDate, 'yyyy.mm.dd') writeDate, hit"
	+ " from board where no = ? ";
	public static final String BOARD_WRITE 
	= " insert into board(no, title, content, writer) "
	+ " values(board_seq.nextval, ?, ?, ?) ";
	public static final String BOARD_UPDATE 
	= " update board set title = ?, content = ?, writer = ? where no = ? ";
	public static final String BOARD_DELETE 
	= " delete from board where no = ? ";
	public static final String BOARD_INCREASE
	= " update board set hit = hit + 1 where no = ? ";
	public static final String BOARD_GET_TOTALROW
	= " select count(*) from board ";
	
	
	// 공지사항 쿼리
	// 1.리스트 - 번호, 제목, 공지시작일, 공지종료일, 최근수정일
	public static final String NOTICE_LIST 
	= "select rnum, no, title, "
	+ " to_char(startDate, 'yyyy.mm.dd') startDate, "
	+ " to_char(endDate, 'yyyy.mm.dd') endDate, "
	+ " to_char(updateDate, 'yyyy.mm.dd') updateDate "
		+ " from( "
		+ " select rownum rnum, no, title, startDate, endDate, updateDate from ("
			+ " select no, title, startDate, endDate, updateDate from notice"
			+ " order by no desc " 
		+ " ) "
	+ ") where rnum between ? and ?  ";
	
	public static final String NOTICE_GET_TOTALROW
	= " select count(*) from board ";
	public static final String NOTICE_WRITE 
	= " insert into notice(no, title, content, startDate, endDate) "
	+ " values(notice_seq.nextval, ?, ?, ?, ?) ";
	
	
	// 회원관리 쿼리 ---------------------------------------------------------
	// 로그인 처리
	public static final String MEMBER_LOGIN
	= " select m.id, m.name, m.gradeNo, g.gradeName from member m, grade g "
	+ " where (m.id = ? and m.pw = ?) and (m.gradeNo = g.gradeNo) ";
	
	// 회원 리스트 처리 - id, name, gender, birth, tel, status, gradeNo, gradeName
	public static final String MEMBER_LIST 
	= " select rnum, id, name, gender, "
	+ " to_char(birth, 'yyyy.mm.dd') birth, tel, status, gradeNo, gradeName from( "
		+ " select rownum rnum, id, name, gender, birth, tel, status, "
		+ " gradeNo, gradeName from ( "
			+ " select m.id, m.name, m.gender, m.birth, m.tel, m.status, "
			+ " m.gradeNo, g.gradeName "
			+ " from member m, grade g "
			+ " where m.gradeNo = g.gradeNo "
			+ " order by id "
		+ " ) "
	+ ") where rnum between ? and ?  ";
	
	// 회원등급 수정
	public static final String MEMBER_GRADE_MODIFY
	= "update member set gradeNo = ? where id = ?";
	
	// 회원 리스트 처리 - id, name, gender, birth, tel, status, gradeNo, gradeName
	public static final String MEMBER_VIEW
	= " select m.id, m.name, m.gender, m.tel, m.email, " +
	// to_char할때 (yy...)하고 나서 뒤에 m. 같은 줄임표시 치면 에러뜸 
			" to_char(m.birth, 'yyyy.mm.dd') birth, " +
			" to_char(m.regDate, 'yyyy.mm.dd') regDate, m.status,  g.gradeNo, g.gradeName  " + 
			" from member m, grade g  " + 
			" where id = ? AND (m.gradeNo = g.gradeNo ) ";
	
	// 메시지  쿼리 --------------------------------------------------------------
	// 메시지 리스트
	public static final String MESSAGE_LIST 
	= "select rnum, no, content, sender, accepter, "
	+ " to_char(sendDate, 'yyyy.mm.dd') sendDate, "
	+ " to_char(acceptDate, 'yyyy.mm.dd') acceptDate, from( "
		+ " select rownum rnum, no, content, sender, accepter, sendDate, acceptDate from ("
			+ " select no, content, sender, accepter, sendDate, acceptDate from message"
			+ " order by no desc "
		+ " ) "
	+ ") where rnum between ? and ?  ";
	
	
	
	
}
