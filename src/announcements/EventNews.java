package announcements;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventNews implements Announcements {

	AnnouncementsDAO ad = new AnnouncementsDAO();
	Date dt = new java.util.Date();

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String adate = sdf.format(dt);

	@Override
	public int addAnnouncement(String netid, String content, String atype, String alink, String aemail) {

		try {
			int temp = ad.add(netid, content, atype, alink, aemail, adate);
			if (temp == 1) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int changeAnnouncement(String id, String netid, String content, String atype, String alink, String aemail) {

		try {
			if (ad.change(id, netid, content, atype, alink, aemail) == 1) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int removeAnnouncement(String id) {
		try {
			if (ad.remove(id) == 1) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

}
