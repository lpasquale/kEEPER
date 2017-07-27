package initial.model.diagram.edit.policies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

/**
 * Extends {@link ChangeBoundsRequest} to calculate the preferred size delta.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SetPreferredSizeRequest extends ChangeBoundsRequest {

	public SetPreferredSizeRequest(IGraphicalEditPart host) {
		super(RequestConstants.REQ_RESIZE);
		setEditParts(host);
		IFigure figure = host.getFigure();
		Dimension prefSize = figure.getLayoutManager().getPreferredSize(figure, -1, -1);
		Dimension currentSize = figure.getSize();
		setSizeDelta(new Dimension(prefSize.width - currentSize.width, prefSize.height - currentSize.height));
	}

}
