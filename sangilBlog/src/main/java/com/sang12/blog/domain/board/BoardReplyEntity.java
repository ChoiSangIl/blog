package com.sang12.blog.domain.board;


import com.sang12.blog.utils.SecurityUtil;

import lombok.Data;

/**
 * 
 * board 댓글 
 * @author sang12
 *
 */
@Data
public class BoardReplyEntity {
	private String reply_id;
    private String board_id;
    private String parent_id;
    private String depth;
    private String reply_content;
    private String reply_writer;
    private String reply_password;
    private String register_datetime;
    
    public String getReply_password() {
    	try {
			return SecurityUtil.getEncSHA256(reply_password);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
    
}
