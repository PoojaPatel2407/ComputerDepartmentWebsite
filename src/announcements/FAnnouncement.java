package announcements;

public class FAnnouncement {

	Announcements announce;

	public int postAnnouncement(String netid, String content, String atype, String aemail, String alink)
			throws Exception {

		if (atype.equals("job")) {
			announce = new Job();
		} else {
			announce = new EventNews();
		}

		if (announce.addAnnouncement(netid, content, atype, alink, aemail) == 1) {
			return 1;
		}

		return 0;

	}

	public int editAnnouncement(String id, String netid, String content, String atype, String aemail, String alink)
			throws Exception {

		if (atype.equals("job")) {
			announce = new Job();
		} else {
			announce = new EventNews();
		}

		if (announce.changeAnnouncement(id, netid, content, atype, alink, aemail) == 1) {
			return 1;
		}

		return 0;

	}

	public int deleteAnnouncement(String id) throws Exception {
		announce = new Job();
		if (announce.removeAnnouncement(id) == 1) {
			return 1;
		}

		return 0;

	}

}
