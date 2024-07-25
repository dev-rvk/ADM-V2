package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldScroll.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002\u001a4\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0000\u001a*\u0010\u0017\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0000¨\u0006\u001b"}, d2 = {"getCursorRectInScroller", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/Density;", "cursorOffset", "", "transformedText", "Landroidx/compose/ui/text/input/TransformedText;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "rtl", "", "textFieldWidth", "textFieldScroll", "Landroidx/compose/ui/Modifier;", "scrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "textLayoutResultProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "textFieldScrollable", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldScrollKt {

    /* compiled from: TextFieldScroll.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ Rect access$getCursorRectInScroller(Density $receiver, int cursorOffset, TransformedText transformedText, TextLayoutResult textLayoutResult, boolean rtl, int textFieldWidth) {
        return getCursorRectInScroller($receiver, cursorOffset, transformedText, textLayoutResult, rtl, textFieldWidth);
    }

    public static /* synthetic */ Modifier textFieldScrollable$default(Modifier modifier, TextFieldScrollerPosition textFieldScrollerPosition, MutableInteractionSource mutableInteractionSource, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            mutableInteractionSource = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return textFieldScrollable(modifier, textFieldScrollerPosition, mutableInteractionSource, z);
    }

    public static final Modifier textFieldScrollable(Modifier $this$textFieldScrollable, final TextFieldScrollerPosition scrollerPosition, final MutableInteractionSource interactionSource, final boolean enabled) {
        Intrinsics.checkNotNullParameter($this$textFieldScrollable, "<this>");
        Intrinsics.checkNotNullParameter(scrollerPosition, "scrollerPosition");
        return ComposedModifierKt.composed($this$textFieldScrollable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("textFieldScrollable");
                $this$null.getProperties().set("scrollerPosition", TextFieldScrollerPosition.this);
                $this$null.getProperties().set("interactionSource", interactionSource);
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* JADX WARN: Removed duplicated region for block: B:30:0x0115  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r19, androidx.compose.runtime.Composer r20, int r21) {
                /*
                    Method dump skipped, instructions count: 284
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
            }
        });
    }

    public static final Modifier textFieldScroll(Modifier $this$textFieldScroll, TextFieldScrollerPosition scrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Function0<TextLayoutResultProxy> textLayoutResultProvider) {
        LayoutModifier layout;
        Intrinsics.checkNotNullParameter($this$textFieldScroll, "<this>");
        Intrinsics.checkNotNullParameter(scrollerPosition, "scrollerPosition");
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        Intrinsics.checkNotNullParameter(visualTransformation, "visualTransformation");
        Intrinsics.checkNotNullParameter(textLayoutResultProvider, "textLayoutResultProvider");
        Orientation orientation = scrollerPosition.getOrientation();
        int cursorOffset = scrollerPosition.m825getOffsetToFollow5zctL8(textFieldValue.getSelection());
        scrollerPosition.m827setPreviousSelection5zctL8(textFieldValue.getSelection());
        TransformedText transformedText = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation, textFieldValue.getText());
        switch (WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
                layout = new VerticalScrollLayoutModifier(scrollerPosition, cursorOffset, transformedText, textLayoutResultProvider);
                break;
            case 2:
                layout = new HorizontalScrollLayoutModifier(scrollerPosition, cursorOffset, transformedText, textLayoutResultProvider);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return ClipKt.clipToBounds($this$textFieldScroll).then(layout);
    }

    public static final Rect getCursorRectInScroller(Density $this$getCursorRectInScroller, int cursorOffset, TransformedText transformedText, TextLayoutResult textLayoutResult, boolean rtl, int textFieldWidth) {
        float cursorLeft;
        float cursorRight;
        Rect cursorRect;
        Rect cursorRect2 = (textLayoutResult == null || (cursorRect = textLayoutResult.getCursorRect(transformedText.getOffsetMapping().originalToTransformed(cursorOffset))) == null) ? Rect.INSTANCE.getZero() : cursorRect;
        int thickness = $this$getCursorRectInScroller.mo323roundToPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
        if (rtl) {
            cursorLeft = (textFieldWidth - cursorRect2.getLeft()) - thickness;
        } else {
            cursorLeft = cursorRect2.getLeft();
        }
        if (rtl) {
            cursorRight = textFieldWidth - cursorRect2.getLeft();
        } else {
            cursorRight = cursorRect2.getLeft() + thickness;
        }
        return Rect.copy$default(cursorRect2, cursorLeft, 0.0f, cursorRight, 0.0f, 10, null);
    }
}
