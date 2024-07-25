package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.selection.BaseTextPreparedSelection;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: TextPreparedSelection.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b)\b \u0018\u0000 c*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002:\u0001cB2\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\fø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002J$\u0010(\u001a\u00028\u00002\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\b,¢\u0006\u0002\u0010-J$\u0010.\u001a\u00028\u00002\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\b,¢\u0006\u0002\u0010-J\u000b\u0010/\u001a\u00028\u0000¢\u0006\u0002\u00100J\r\u00101\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\r\u00103\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\u0006\u00104\u001a\u00020&J\r\u00105\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\b\u00106\u001a\u00020&H\u0002J\b\u00107\u001a\u00020&H\u0002J\u0006\u00108\u001a\u00020&J\r\u00109\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\b\u0010:\u001a\u00020;H\u0002J\u000b\u0010<\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010=\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010>\u001a\u00028\u0000¢\u0006\u0002\u00100J\r\u0010?\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00100J\u000b\u0010@\u001a\u00028\u0000¢\u0006\u0002\u00100J\r\u0010A\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00100J\r\u0010B\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00100J\u000b\u0010C\u001a\u00028\u0000¢\u0006\u0002\u00100J\r\u0010D\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00100J\u000b\u0010E\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010F\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010G\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010H\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010I\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010J\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010K\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010L\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010M\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010N\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010O\u001a\u00028\u0000¢\u0006\u0002\u00100J\u0010\u0010P\u001a\u00020+2\u0006\u0010'\u001a\u00020&H\u0004J\u0018\u0010Q\u001a\u00020+2\u0006\u0010R\u001a\u00020&2\u0006\u0010S\u001a\u00020&H\u0004J\b\u0010T\u001a\u00020&H\u0002J\b\u0010U\u001a\u00020&H\u0002J\b\u0010V\u001a\u00020&H\u0002J>\u0010W\u001a\u00028\u0000\"\u0004\b\u0001\u0010X*\u0002HX2\b\b\u0002\u0010Y\u001a\u00020;2\u0017\u0010Z\u001a\u0013\u0012\u0004\u0012\u0002HX\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\b,H\u0084\bø\u0001\u0003¢\u0006\u0002\u0010[J\u0016\u0010\\\u001a\u00020&*\u00020\b2\b\b\u0002\u0010]\u001a\u00020&H\u0002J\u0016\u0010^\u001a\u00020&*\u00020\b2\b\b\u0002\u0010]\u001a\u00020&H\u0002J\u0017\u0010_\u001a\u00020&*\u00020\b2\b\b\u0002\u0010]\u001a\u00020&H\u0082\u0010J\u0017\u0010`\u001a\u00020&*\u00020\b2\b\b\u0002\u0010]\u001a\u00020&H\u0082\u0010J\u0014\u0010a\u001a\u00020&*\u00020\b2\u0006\u0010b\u001a\u00020&H\u0002R\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R%\u0010\u001b\u001a\u00020\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$\u0082\u0002\u0016\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006d"}, d2 = {"Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "T", "", "originalText", "Landroidx/compose/ui/text/AnnotatedString;", "originalSelection", "Landroidx/compose/ui/text/TextRange;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "annotatedString", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "setAnnotatedString", "(Landroidx/compose/ui/text/AnnotatedString;)V", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "getOriginalSelection-d9O1mEE", "()J", "J", "getOriginalText", "selection", "getSelection-d9O1mEE", "setSelection-5zc-tL8", "(J)V", "getState", "()Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "text", "", "getText$foundation_release", "()Ljava/lang/String;", "charOffset", "", "offset", "collapseLeftOr", "or", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "collapseRightOr", "deselect", "()Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "getLineEndByOffset", "()Ljava/lang/Integer;", "getLineStartByOffset", "getNextCharacterIndex", "getNextWordOffset", "getParagraphEnd", "getParagraphStart", "getPrecedingCharacterIndex", "getPreviousWordOffset", "isLtr", "", "moveCursorDownByLine", "moveCursorLeft", "moveCursorLeftByWord", "moveCursorNext", "moveCursorNextByParagraph", "moveCursorNextByWord", "moveCursorPrev", "moveCursorPrevByParagraph", "moveCursorPrevByWord", "moveCursorRight", "moveCursorRightByWord", "moveCursorToEnd", "moveCursorToHome", "moveCursorToLineEnd", "moveCursorToLineLeftSide", "moveCursorToLineRightSide", "moveCursorToLineStart", "moveCursorUpByLine", "selectAll", "selectMovement", "setCursor", "setSelection", "start", "end", "transformedEndOffset", "transformedMaxOffset", "transformedMinOffset", "apply", "U", "resetCachedX", "block", "(Ljava/lang/Object;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "getLineEndByOffsetForLayout", "currentOffset", "getLineStartByOffsetForLayout", "getNextWordOffsetForLayout", "getPrevWordOffset", "jumpByLinesOffset", "linesAmount", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public abstract class BaseTextPreparedSelection<T extends BaseTextPreparedSelection<T>> {
    public static final int NoCharacterFound = -1;
    private AnnotatedString annotatedString;
    private final TextLayoutResult layoutResult;
    private final OffsetMapping offsetMapping;
    private final long originalSelection;
    private final AnnotatedString originalText;
    private long selection;
    private final TextPreparedSelectionState state;

    public /* synthetic */ BaseTextPreparedSelection(AnnotatedString annotatedString, long j, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, TextPreparedSelectionState textPreparedSelectionState, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, j, textLayoutResult, offsetMapping, textPreparedSelectionState);
    }

    private BaseTextPreparedSelection(AnnotatedString originalText, long originalSelection, TextLayoutResult layoutResult, OffsetMapping offsetMapping, TextPreparedSelectionState state) {
        Intrinsics.checkNotNullParameter(originalText, "originalText");
        Intrinsics.checkNotNullParameter(offsetMapping, "offsetMapping");
        Intrinsics.checkNotNullParameter(state, "state");
        this.originalText = originalText;
        this.originalSelection = originalSelection;
        this.layoutResult = layoutResult;
        this.offsetMapping = offsetMapping;
        this.state = state;
        this.selection = this.originalSelection;
        this.annotatedString = this.originalText;
    }

    public final AnnotatedString getOriginalText() {
        return this.originalText;
    }

    /* renamed from: getOriginalSelection-d9O1mEE, reason: not valid java name and from getter */
    public final long getOriginalSelection() {
        return this.originalSelection;
    }

    public final TextLayoutResult getLayoutResult() {
        return this.layoutResult;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final TextPreparedSelectionState getState() {
        return this.state;
    }

    /* renamed from: getSelection-d9O1mEE, reason: not valid java name and from getter */
    public final long getSelection() {
        return this.selection;
    }

    /* renamed from: setSelection-5zc-tL8, reason: not valid java name */
    public final void m877setSelection5zctL8(long j) {
        this.selection = j;
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public final void setAnnotatedString(AnnotatedString annotatedString) {
        Intrinsics.checkNotNullParameter(annotatedString, "<set-?>");
        this.annotatedString = annotatedString;
    }

    public final String getText$foundation_release() {
        return this.annotatedString.getText();
    }

    public static /* synthetic */ BaseTextPreparedSelection apply$default(BaseTextPreparedSelection $this, Object $receiver, boolean resetCachedX, Function1 block, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: apply");
        }
        if ((i & 1) != 0) {
            resetCachedX = true;
        }
        Intrinsics.checkNotNullParameter(block, "block");
        if (resetCachedX) {
            $this.getState().resetCachedX();
        }
        if ($this.getText$foundation_release().length() > 0) {
            block.invoke($receiver);
        }
        Intrinsics.checkNotNull($receiver, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection) $receiver;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final <U> T apply(U u, boolean resetCachedX, Function1<? super U, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (resetCachedX) {
            getState().resetCachedX();
        }
        if (getText$foundation_release().length() > 0) {
            block.invoke(u);
        }
        Intrinsics.checkNotNull(u, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (T) u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setCursor(int offset) {
        setSelection(offset, offset);
    }

    protected final void setSelection(int start, int end) {
        this.selection = TextRangeKt.TextRange(start, end);
    }

    public final T selectAll() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection<T> $this$selectAll_u24lambda_u240 = this;
            $this$selectAll_u24lambda_u240.setSelection(0, $this$selectAll_u24lambda_u240.getText$foundation_release().length());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T deselect() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection<T> $this$deselect_u24lambda_u241 = this;
            $this$deselect_u24lambda_u241.setCursor(TextRange.m4721getEndimpl($this$deselect_u24lambda_u241.selection));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorLeft() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection<T> $this$moveCursorLeft_u24lambda_u242 = this;
            if ($this$moveCursorLeft_u24lambda_u242.isLtr()) {
                $this$moveCursorLeft_u24lambda_u242.moveCursorPrev();
            } else {
                $this$moveCursorLeft_u24lambda_u242.moveCursorNext();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorRight() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection<T> $this$moveCursorRight_u24lambda_u243 = this;
            if ($this$moveCursorRight_u24lambda_u243.isLtr()) {
                $this$moveCursorRight_u24lambda_u243.moveCursorNext();
            } else {
                $this$moveCursorRight_u24lambda_u243.moveCursorPrev();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T collapseLeftOr(Function1<? super T, Unit> or) {
        Intrinsics.checkNotNullParameter(or, "or");
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection<T> $this$collapseLeftOr_u24lambda_u244 = this;
            if (TextRange.m4720getCollapsedimpl($this$collapseLeftOr_u24lambda_u244.selection)) {
                Intrinsics.checkNotNull($this$collapseLeftOr_u24lambda_u244, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection.collapseLeftOr$lambda$4");
                or.invoke($this$collapseLeftOr_u24lambda_u244);
            } else if ($this$collapseLeftOr_u24lambda_u244.isLtr()) {
                $this$collapseLeftOr_u24lambda_u244.setCursor(TextRange.m4724getMinimpl($this$collapseLeftOr_u24lambda_u244.selection));
            } else {
                $this$collapseLeftOr_u24lambda_u244.setCursor(TextRange.m4723getMaximpl($this$collapseLeftOr_u24lambda_u244.selection));
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T collapseRightOr(Function1<? super T, Unit> or) {
        Intrinsics.checkNotNullParameter(or, "or");
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection<T> $this$collapseRightOr_u24lambda_u245 = this;
            if (TextRange.m4720getCollapsedimpl($this$collapseRightOr_u24lambda_u245.selection)) {
                Intrinsics.checkNotNull($this$collapseRightOr_u24lambda_u245, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection.collapseRightOr$lambda$5");
                or.invoke($this$collapseRightOr_u24lambda_u245);
            } else if ($this$collapseRightOr_u24lambda_u245.isLtr()) {
                $this$collapseRightOr_u24lambda_u245.setCursor(TextRange.m4723getMaximpl($this$collapseRightOr_u24lambda_u245.selection));
            } else {
                $this$collapseRightOr_u24lambda_u245.setCursor(TextRange.m4724getMinimpl($this$collapseRightOr_u24lambda_u245.selection));
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final int getPrecedingCharacterIndex() {
        return StringHelpers_androidKt.findPrecedingBreak(this.annotatedString.getText(), TextRange.m4721getEndimpl(this.selection));
    }

    public final int getNextCharacterIndex() {
        return StringHelpers_androidKt.findFollowingBreak(this.annotatedString.getText(), TextRange.m4721getEndimpl(this.selection));
    }

    private final T moveCursorPrev() {
        BaseTextPreparedSelection<T> $this$moveCursorPrev_u24lambda_u246;
        int prev;
        getState().resetCachedX();
        if ((getText$foundation_release().length() > 0) && (prev = ($this$moveCursorPrev_u24lambda_u246 = this).getPrecedingCharacterIndex()) != -1) {
            $this$moveCursorPrev_u24lambda_u246.setCursor(prev);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final T moveCursorNext() {
        BaseTextPreparedSelection<T> $this$moveCursorNext_u24lambda_u247;
        int next;
        getState().resetCachedX();
        if ((getText$foundation_release().length() > 0) && (next = ($this$moveCursorNext_u24lambda_u247 = this).getNextCharacterIndex()) != -1) {
            $this$moveCursorNext_u24lambda_u247.setCursor(next);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorToHome() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection<T> $this$moveCursorToHome_u24lambda_u248 = this;
            $this$moveCursorToHome_u24lambda_u248.setCursor(0);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorToEnd() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection<T> $this$moveCursorToEnd_u24lambda_u249 = this;
            $this$moveCursorToEnd_u24lambda_u249.setCursor($this$moveCursorToEnd_u24lambda_u249.getText$foundation_release().length());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorLeftByWord() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection<T> $this$moveCursorLeftByWord_u24lambda_u2410 = this;
            if ($this$moveCursorLeftByWord_u24lambda_u2410.isLtr()) {
                $this$moveCursorLeftByWord_u24lambda_u2410.moveCursorPrevByWord();
            } else {
                $this$moveCursorLeftByWord_u24lambda_u2410.moveCursorNextByWord();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorRightByWord() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection<T> $this$moveCursorRightByWord_u24lambda_u2411 = this;
            if ($this$moveCursorRightByWord_u24lambda_u2411.isLtr()) {
                $this$moveCursorRightByWord_u24lambda_u2411.moveCursorNextByWord();
            } else {
                $this$moveCursorRightByWord_u24lambda_u2411.moveCursorPrevByWord();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final Integer getNextWordOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getNextWordOffsetForLayout$default(this, textLayoutResult, 0, 1, null));
        }
        return null;
    }

    private final T moveCursorNextByWord() {
        BaseTextPreparedSelection<T> $this$moveCursorNextByWord_u24lambda_u2413;
        Integer nextWordOffset;
        getState().resetCachedX();
        if ((getText$foundation_release().length() > 0) && (nextWordOffset = ($this$moveCursorNextByWord_u24lambda_u2413 = this).getNextWordOffset()) != null) {
            int it = nextWordOffset.intValue();
            $this$moveCursorNextByWord_u24lambda_u2413.setCursor(it);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final Integer getPreviousWordOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getPrevWordOffset$default(this, textLayoutResult, 0, 1, null));
        }
        return null;
    }

    private final T moveCursorPrevByWord() {
        BaseTextPreparedSelection<T> $this$moveCursorPrevByWord_u24lambda_u2415;
        Integer previousWordOffset;
        getState().resetCachedX();
        if ((getText$foundation_release().length() > 0) && (previousWordOffset = ($this$moveCursorPrevByWord_u24lambda_u2415 = this).getPreviousWordOffset()) != null) {
            int it = previousWordOffset.intValue();
            $this$moveCursorPrevByWord_u24lambda_u2415.setCursor(it);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorPrevByParagraph() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection<T> $this$moveCursorPrevByParagraph_u24lambda_u2416 = this;
            $this$moveCursorPrevByParagraph_u24lambda_u2416.setCursor($this$moveCursorPrevByParagraph_u24lambda_u2416.getParagraphStart());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorNextByParagraph() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection<T> $this$moveCursorNextByParagraph_u24lambda_u2417 = this;
            $this$moveCursorNextByParagraph_u24lambda_u2417.setCursor($this$moveCursorNextByParagraph_u24lambda_u2417.getParagraphEnd());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorUpByLine() {
        BaseTextPreparedSelection<T> $this$moveCursorUpByLine_u24lambda_u2419;
        TextLayoutResult textLayoutResult;
        if ((getText$foundation_release().length() > 0) && (textLayoutResult = ($this$moveCursorUpByLine_u24lambda_u2419 = this).layoutResult) != null) {
            int it = $this$moveCursorUpByLine_u24lambda_u2419.jumpByLinesOffset(textLayoutResult, -1);
            $this$moveCursorUpByLine_u24lambda_u2419.setCursor(it);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorDownByLine() {
        BaseTextPreparedSelection<T> $this$moveCursorDownByLine_u24lambda_u2421;
        TextLayoutResult textLayoutResult;
        if ((getText$foundation_release().length() > 0) && (textLayoutResult = ($this$moveCursorDownByLine_u24lambda_u2421 = this).layoutResult) != null) {
            int it = $this$moveCursorDownByLine_u24lambda_u2421.jumpByLinesOffset(textLayoutResult, 1);
            $this$moveCursorDownByLine_u24lambda_u2421.setCursor(it);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final Integer getLineStartByOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getLineStartByOffsetForLayout$default(this, textLayoutResult, 0, 1, null));
        }
        return null;
    }

    public final T moveCursorToLineStart() {
        BaseTextPreparedSelection<T> $this$moveCursorToLineStart_u24lambda_u2423;
        Integer lineStartByOffset;
        getState().resetCachedX();
        if ((getText$foundation_release().length() > 0) && (lineStartByOffset = ($this$moveCursorToLineStart_u24lambda_u2423 = this).getLineStartByOffset()) != null) {
            int it = lineStartByOffset.intValue();
            $this$moveCursorToLineStart_u24lambda_u2423.setCursor(it);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final Integer getLineEndByOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getLineEndByOffsetForLayout$default(this, textLayoutResult, 0, 1, null));
        }
        return null;
    }

    public final T moveCursorToLineEnd() {
        BaseTextPreparedSelection<T> $this$moveCursorToLineEnd_u24lambda_u2425;
        Integer lineEndByOffset;
        getState().resetCachedX();
        if ((getText$foundation_release().length() > 0) && (lineEndByOffset = ($this$moveCursorToLineEnd_u24lambda_u2425 = this).getLineEndByOffset()) != null) {
            int it = lineEndByOffset.intValue();
            $this$moveCursorToLineEnd_u24lambda_u2425.setCursor(it);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorToLineLeftSide() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection<T> $this$moveCursorToLineLeftSide_u24lambda_u2426 = this;
            if ($this$moveCursorToLineLeftSide_u24lambda_u2426.isLtr()) {
                $this$moveCursorToLineLeftSide_u24lambda_u2426.moveCursorToLineStart();
            } else {
                $this$moveCursorToLineLeftSide_u24lambda_u2426.moveCursorToLineEnd();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorToLineRightSide() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection<T> $this$moveCursorToLineRightSide_u24lambda_u2427 = this;
            if ($this$moveCursorToLineRightSide_u24lambda_u2427.isLtr()) {
                $this$moveCursorToLineRightSide_u24lambda_u2427.moveCursorToLineEnd();
            } else {
                $this$moveCursorToLineRightSide_u24lambda_u2427.moveCursorToLineStart();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T selectMovement() {
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection<T> $this$selectMovement_u24lambda_u2428 = this;
            $this$selectMovement_u24lambda_u2428.selection = TextRangeKt.TextRange(TextRange.m4726getStartimpl($this$selectMovement_u24lambda_u2428.originalSelection), TextRange.m4721getEndimpl($this$selectMovement_u24lambda_u2428.selection));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final boolean isLtr() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        ResolvedTextDirection direction = textLayoutResult != null ? textLayoutResult.getParagraphDirection(transformedEndOffset()) : null;
        return direction != ResolvedTextDirection.Rtl;
    }

    static /* synthetic */ int getNextWordOffsetForLayout$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNextWordOffsetForLayout");
        }
        if ((i2 & 1) != 0) {
            i = baseTextPreparedSelection.transformedEndOffset();
        }
        return baseTextPreparedSelection.getNextWordOffsetForLayout(textLayoutResult, i);
    }

    private final int getNextWordOffsetForLayout(TextLayoutResult $this$getNextWordOffsetForLayout, int currentOffset) {
        while (currentOffset < this.originalText.length()) {
            long currentWord = $this$getNextWordOffsetForLayout.m4700getWordBoundaryjx7JFs(charOffset(currentOffset));
            if (TextRange.m4721getEndimpl(currentWord) <= currentOffset) {
                currentOffset++;
            } else {
                return this.offsetMapping.transformedToOriginal(TextRange.m4721getEndimpl(currentWord));
            }
        }
        return this.originalText.length();
    }

    static /* synthetic */ int getPrevWordOffset$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPrevWordOffset");
        }
        if ((i2 & 1) != 0) {
            i = baseTextPreparedSelection.transformedEndOffset();
        }
        return baseTextPreparedSelection.getPrevWordOffset(textLayoutResult, i);
    }

    private final int getPrevWordOffset(TextLayoutResult $this$getPrevWordOffset, int currentOffset) {
        while (currentOffset > 0) {
            long currentWord = $this$getPrevWordOffset.m4700getWordBoundaryjx7JFs(charOffset(currentOffset));
            if (TextRange.m4726getStartimpl(currentWord) >= currentOffset) {
                currentOffset--;
            } else {
                return this.offsetMapping.transformedToOriginal(TextRange.m4726getStartimpl(currentWord));
            }
        }
        return 0;
    }

    static /* synthetic */ int getLineStartByOffsetForLayout$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineStartByOffsetForLayout");
        }
        if ((i2 & 1) != 0) {
            i = baseTextPreparedSelection.transformedMinOffset();
        }
        return baseTextPreparedSelection.getLineStartByOffsetForLayout(textLayoutResult, i);
    }

    private final int getLineStartByOffsetForLayout(TextLayoutResult $this$getLineStartByOffsetForLayout, int currentOffset) {
        int currentLine = $this$getLineStartByOffsetForLayout.getLineForOffset(currentOffset);
        return this.offsetMapping.transformedToOriginal($this$getLineStartByOffsetForLayout.getLineStart(currentLine));
    }

    static /* synthetic */ int getLineEndByOffsetForLayout$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineEndByOffsetForLayout");
        }
        if ((i2 & 1) != 0) {
            i = baseTextPreparedSelection.transformedMaxOffset();
        }
        return baseTextPreparedSelection.getLineEndByOffsetForLayout(textLayoutResult, i);
    }

    private final int getLineEndByOffsetForLayout(TextLayoutResult $this$getLineEndByOffsetForLayout, int currentOffset) {
        int currentLine = $this$getLineEndByOffsetForLayout.getLineForOffset(currentOffset);
        return this.offsetMapping.transformedToOriginal($this$getLineEndByOffsetForLayout.getLineEnd(currentLine, true));
    }

    private final int jumpByLinesOffset(TextLayoutResult $this$jumpByLinesOffset, int linesAmount) {
        int currentOffset = transformedEndOffset();
        if (this.state.getCachedX() == null) {
            this.state.setCachedX(Float.valueOf($this$jumpByLinesOffset.getCursorRect(currentOffset).getLeft()));
        }
        int targetLine = $this$jumpByLinesOffset.getLineForOffset(currentOffset) + linesAmount;
        if (targetLine < 0) {
            return 0;
        }
        if (targetLine >= $this$jumpByLinesOffset.getLineCount()) {
            return getText$foundation_release().length();
        }
        float y = $this$jumpByLinesOffset.getLineBottom(targetLine) - 1;
        Float cachedX = this.state.getCachedX();
        Intrinsics.checkNotNull(cachedX);
        Float f = cachedX;
        float it = f.floatValue();
        if ((!isLtr() || it < $this$jumpByLinesOffset.getLineRight(targetLine)) && (isLtr() || it > $this$jumpByLinesOffset.getLineLeft(targetLine))) {
            float x = f.floatValue();
            return this.offsetMapping.transformedToOriginal($this$jumpByLinesOffset.m4698getOffsetForPositionk4lQ0M(OffsetKt.Offset(x, y)));
        }
        return $this$jumpByLinesOffset.getLineEnd(targetLine, true);
    }

    private final int transformedEndOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m4721getEndimpl(this.selection));
    }

    private final int transformedMinOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m4724getMinimpl(this.selection));
    }

    private final int transformedMaxOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m4723getMaximpl(this.selection));
    }

    private final int charOffset(int offset) {
        return RangesKt.coerceAtMost(offset, getText$foundation_release().length() - 1);
    }

    private final int getParagraphStart() {
        return StringHelpersKt.findParagraphStart(getText$foundation_release(), TextRange.m4724getMinimpl(this.selection));
    }

    private final int getParagraphEnd() {
        return StringHelpersKt.findParagraphEnd(getText$foundation_release(), TextRange.m4723getMaximpl(this.selection));
    }
}
