package client;

import com.google.gwt.event.shared.GwtEvent;

public class classEvent extends GwtEvent<classEventHandlers> {
	public static Type<classEventHandlers> TYPE = new Type<classEventHandlers>();

	public Type<classEventHandlers> getAssociatedType() {
		return TYPE;
	}

	protected void dispatch(classEventHandlers handler) {
		handler.onclass(this);
	}
}
