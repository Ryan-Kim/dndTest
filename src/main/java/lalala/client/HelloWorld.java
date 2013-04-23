package lalala.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.UIObject;

/**
 * Created with IntelliJ IDEA.
 * User: nightingale
 * Date: 23/04/13
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorld extends UIObject{

    interface Binder extends UiBinder<DivElement, HelloWorld> {}
    private static Binder uiBinder = GWT.create(Binder.class);

    @UiField SpanElement nameSpan;

    public HelloWorld() {
        setElement(uiBinder.createAndBindUi(this));

    }

    public void setName(String name) {
        this.nameSpan.setInnerText(name);
    }
}
