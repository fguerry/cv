package fr.fguerry.cv.render;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.fguerry.cv.model.CvBlock;
import fr.fguerry.cv.model.CvCompositeElement;
import fr.fguerry.cv.model.CvContent;
import fr.fguerry.cv.model.CvElement;

/**
 * Base abstract class that factorizes some common behavior for several
 * {@link CvRenderer}s.
 * 
 * @author fguerry
 *
 * @param <Context> type of the main item to be used as a context to render the
 *            whole CV
 * @param <BlocksContext> type of the secondary item to be used as a context to
 *            render the {@link CvBlock}s.
 */
public abstract class AbstractCvRenderer<Context, BlocksContext> implements CvRenderer {

	private Map<Class<? extends CvElement>, BlockRenderer<? extends CvElement, BlocksContext>> renderers;

	public AbstractCvRenderer(Class<? extends BlockRenderer<? extends CvElement, BlocksContext>>... renderers) {
		this.renderers = new HashMap<>();
		for (Class<? extends BlockRenderer<?, BlocksContext>> renderer : renderers) {
			final BlockRendererRange annotation = renderer.getAnnotation(BlockRendererRange.class);
			if (annotation == null) {
				throw new RuntimeException("missing annotation @" + BlockRendererRange.class.getSimpleName() + " in renderer " + renderer);
			}
			try {
				this.renderers.put(annotation.value(), renderer.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				throw new RuntimeException("unable to create renderer " + renderer, e);
			}
		}
	}

	@Override
	public void render(CvContent cv) {
		final Context context = createContext(cv);
		renderInContext(cv, context);
		showInContext(cv, context);
	}

	public void renderInContext(CvContent cv, Context context) {
		final BlocksContext blocksContext = createBlockContext(cv, context);
		blocksLoop(cv, blocksContext);
	}

	private <Type extends CvElement> void blocksLoop(CvCompositeElement<Type> composite, final BlocksContext blocksContext) {
		final List<Type> blocks = composite.getBlocks();
		if (blocks != null) {
			for (CvElement block : blocks) {
				final BlockRenderer<CvElement, BlocksContext> renderer = (BlockRenderer<CvElement, BlocksContext>) renderers.get(block.getClass());
				if (renderer == null) {
					throw new RuntimeException("no registered renderer for block " + block);
				}
				renderer.renderInContext(block, blocksContext);
				if (block instanceof CvCompositeElement<?>) {
					CvCompositeElement<?> sub = (CvCompositeElement<?>) block;
					blocksLoop(sub, blocksContext);
				}
			}
		}
	}

	public abstract Context createContext(CvContent cv);

	public abstract BlocksContext createBlockContext(CvContent cv, Context context);

	public abstract void showInContext(CvContent cv, Context context);
}
