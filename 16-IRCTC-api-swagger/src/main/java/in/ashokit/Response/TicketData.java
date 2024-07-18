package in.ashokit.Response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TicketData {

	private Integer ticketId;
	private String from;
	private String to;
	private String doj;
	private String ticketamt;
	private String ticketStatus;

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getTicketamt() {
		return ticketamt;
	}

	public void setTicketamt(String ticketamt) {
		this.ticketamt = ticketamt;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	@Override
	public String toString() {
		return "TicketData [ticketId=" + ticketId + ", from=" + from + ", to=" + to + ", doj=" + doj + ", ticketamt="
				+ ticketamt + ", ticketStatus=" + ticketStatus + "]";
	}
	
	
}
