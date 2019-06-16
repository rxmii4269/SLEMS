package client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;

public class Binder {
	private static BinderUiBinder ourUiBinder = GWT.create(BinderUiBinder.class);

	public Binder() {
		DivElement rootElement = ourUiBinder.createAndBindUi(this);
	}

	interface BinderUiBinder extends UiBinder<DivElement, Binder> {
	}
}