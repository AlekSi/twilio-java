package com.twilio.sdk.resource.instance;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.TwilioRestResponse;
import com.twilio.sdk.resource.InstanceResource;

import java.util.Date;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class OutgoingCallerId.
 *
 * For more information see <a href="https://www.twilio.com/docs/api/rest/outgoing-caller-ids">https://www.twilio.com/docs/api/rest/outgoing-caller-ids</a>
 */
public class OutgoingCallerId extends InstanceResource {

	/** The Constant SID_PROPERTY. */
	private static final String SID_PROPERTY = "sid";

	/**
	 * Instantiates a new outgoing caller id.
	 *
	 * @param client the client
	 */
	public OutgoingCallerId(TwilioRestClient client) {
		super(client);
	}

	/**
	 * Instantiates a new outgoing caller id.
	 *
	 * @param client the client
	 * @param sid the sid
	 */
	public OutgoingCallerId(TwilioRestClient client, String sid) {
		super(client);
		if (sid == null) {
            throw new IllegalStateException("The Sid for an OutgoingCallerId can not be null");
        }
		this.setProperty(SID_PROPERTY, sid);
	}

	/**
	 * Instantiates a new outgoing caller id.
	 *
	 * @param client the client
	 * @param properties the properties
	 */
	public OutgoingCallerId(TwilioRestClient client, Map<String, Object> properties) {
		super(client, properties);
	}

	/* (non-Javadoc)
	 * @see com.twilio.sdk.resource.Resource#getResourceLocation()
	 */
	@Override
	protected String getResourceLocation() {
		return "/" + TwilioRestClient.DEFAULT_VERSION + "/Accounts/"
				+ this.getRequestAccountSid() + "/OutgoingCallerIds/" + this.getSid() + ".json";
	}

	/*
	 * Property getters
	 */
	/**
	 * Gets the sid.
	 *
	 * @return the sid
	 */
	public String getSid() {
		return this.getProperty(SID_PROPERTY);
	}

	/**
	 * Gets the date created.
	 *
	 * @return the date created
	 */
	public Date getDateCreated() {
		return getDateProperty("date_created");
	}

	/**
	 * Gets the date updated.
	 *
	 * @return the date updated
	 */
	public Date getDateUpdated() {
		return getDateProperty("date_updated");
	}

	/**
	 * Gets the friendly name.
	 *
	 * @return the friendly name
	 */
	public String getFriendlyName() {
		return this.getProperty("friendly_name");
	}

	/**
	 * Gets the account sid.
	 *
	 * @return the account sid
	 */
	public String getAccountSid() {
		return this.getProperty("account_sid");
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return this.getProperty("phone_number");
	}

	/**
	 * Delete this CallerId
	 *
	 * @return true, if successful
	 * @throws TwilioRestException the twilio rest exception
	 */
	public boolean delete() throws TwilioRestException {
		TwilioRestResponse response = this.getClient().safeRequest(
				this.getResourceLocation(), "DELETE", (Map) null);

		return !response.isError();
	}
}
