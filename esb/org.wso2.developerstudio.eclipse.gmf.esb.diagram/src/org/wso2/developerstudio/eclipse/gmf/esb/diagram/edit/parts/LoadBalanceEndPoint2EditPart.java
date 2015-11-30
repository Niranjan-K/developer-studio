package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.wso2.developerstudio.eclipse.gmf.esb.ComplexEndpoints;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequences;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpoint2;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractSequencesEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.ComplexFiguredAbstractEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGraphicalShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGraphicalShapeWithLabel;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.OpenSeparatelyEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.LoadBalanceEndPoint2CanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.LoadBalanceEndPoint2ItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;

/**
 * @generated NOT
 */
public class LoadBalanceEndPoint2EditPart extends
		ComplexFiguredAbstractEndpoint {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3656;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	public LoadBalanceEndPoint2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new LoadBalanceEndPoint2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new LoadBalanceEndPoint2CanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// For handle Double click Event.
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,
				new OpenSeparatelyEditPolicy());
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (EsbVisualIDRegistry.getVisualID(childView)) {
				case LoadBalanceEndPointInputConnector2EditPart.VISUAL_ID:
				case LoadBalanceEndPointOutputConnector2EditPart.VISUAL_ID:
				case LoadBalanceEndPointWestOutputConnector2EditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy();
				}
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new LoadBalanceEndPointFigure();
	}

	/**
	 * @generated
	 */
	public LoadBalanceEndPointFigure getPrimaryShape() {
		return (LoadBalanceEndPointFigure) primaryShape;
	}

	/**
	 * @generated NOT
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof LoadBalanceEndPointEndPointName2EditPart) {
			((LoadBalanceEndPointEndPointName2EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureLoadBalanceEndPointNamePropertyLabel());
			return true;
		}
		if (childEditPart instanceof LoadBalanceEndPointInputConnector2EditPart) {
			double position;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (childEditPart
					.getParent()).getModel()).getElement();
			if (((LoadBalanceEndPoint) parentEndpoint).getInputConnector()
					.getIncomingLinks().size() != 0) {
				EObject source = ((LoadBalanceEndPoint) parentEndpoint)
						.getInputConnector().getIncomingLinks().get(0)
						.getSource().eContainer();
				/*
				 * Position of input connector of the endpoint should be 0.5 inside ComplexEndpoints and Sequences. 
				 */
				position = ((source instanceof ComplexEndpoints) || (source
						.eContainer().eContainer() instanceof Sequences)) ? 0.5
						: 0.25;
			} else {
				position = ((this.getParent().getParent().getParent() instanceof ComplexEndpointsEditPart) || (this
						.getParent().getParent().getParent() instanceof AbstractSequencesEditPart)) ? 0.5
						: 0.25;
			}
			IFigure borderItemFigure = ((LoadBalanceEndPointInputConnector2EditPart) childEditPart)
					.getFigure();
			BorderItemLocator locator = new FixedBorderItemLocator(
					getMainFigure(), borderItemFigure, PositionConstants.WEST,
					position);
			getBorderedFigure().getBorderItemContainer().add(borderItemFigure,
					locator);
			return true;
		}
		if (childEditPart instanceof LoadBalanceEndPointWestOutputConnector2EditPart) {
			IFigure borderItemFigure = ((LoadBalanceEndPointWestOutputConnector2EditPart) childEditPart)
					.getFigure();
			BorderItemLocator locator = new FixedBorderItemLocator(
					getMainFigure(), borderItemFigure, PositionConstants.WEST,
					0.75);
			getBorderedFigure().getBorderItemContainer().add(borderItemFigure,
					locator);
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof LoadBalanceEndPointEndPointName2EditPart) {
			return true;
		}
		if (childEditPart instanceof LoadBalanceEndPointInputConnector2EditPart) {
			getBorderedFigure()
					.getBorderItemContainer()
					.remove(((LoadBalanceEndPointInputConnector2EditPart) childEditPart)
							.getFigure());
			return true;
		}
		if (childEditPart instanceof LoadBalanceEndPointOutputConnector2EditPart) {
			getBorderedFigure()
					.getBorderItemContainer()
					.remove(((LoadBalanceEndPointOutputConnector2EditPart) childEditPart)
							.getFigure());
			return true;
		}
		if (childEditPart instanceof LoadBalanceEndPointWestOutputConnector2EditPart) {
			getBorderedFigure()
					.getBorderItemContainer()
					.remove(((LoadBalanceEndPointWestOutputConnector2EditPart) childEditPart)
							.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(EsbVisualIDRegistry
				.getType(LoadBalanceEndPointEndPointName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated NOT
	 */
	public class LoadBalanceEndPointFigure extends EsbGraphicalShape {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLoadBalanceEndPointNamePropertyLabel;

		/**
		 * @generated
		 */
		public LoadBalanceEndPointFigure() {

			this.setBackgroundColor(THIS_BACK);
			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			fFigureLoadBalanceEndPointNamePropertyLabel = new WrappingLabel();
			fFigureLoadBalanceEndPointNamePropertyLabel.setText("<...>");
			fFigureLoadBalanceEndPointNamePropertyLabel
					.setAlignment(SWT.CENTER);
			this.getPropertyValueRectangle1().add(
					fFigureLoadBalanceEndPointNamePropertyLabel);
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLoadBalanceEndPointNamePropertyLabel() {
			return fFigureLoadBalanceEndPointNamePropertyLabel;
		}

		public String getIconPath() {
			return "icons/ico20/loadbalance-endpoint.gif";
		}

		public String getNodeName() {
			return "LoadBalance-EP";
		}

		public Color getBackgroundColor() {
			return THIS_BACK;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 255, 255, 255);

}