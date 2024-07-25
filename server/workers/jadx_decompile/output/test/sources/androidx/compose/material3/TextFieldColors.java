package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldDefaults.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001Bâ\u0002\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010/J0\u00104\u001a\b\u0012\u0004\u0012\u00020\u0003052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020:H\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010<J \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u0003052\u0006\u00108\u001a\u000207H\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u0013\u0010?\u001a\u0002072\b\u0010@\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010A\u001a\u00020BH\u0016J0\u0010C\u001a\b\u0012\u0004\u0012\u00020\u0003052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020:H\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010<J0\u0010E\u001a\b\u0012\u0004\u0012\u00020\u0003052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020:H\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010<J0\u0010G\u001a\b\u0012\u0004\u0012\u00020\u0003052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020:H\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010<J0\u0010I\u001a\b\u0012\u0004\u0012\u00020\u0003052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020:H\u0001ø\u0001\u0000¢\u0006\u0004\bJ\u0010<J0\u0010K\u001a\b\u0012\u0004\u0012\u00020\u0003052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020:H\u0001ø\u0001\u0000¢\u0006\u0004\bL\u0010<J0\u0010M\u001a\b\u0012\u0004\u0012\u00020\u0003052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020:H\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010<J0\u0010O\u001a\b\u0012\u0004\u0012\u00020\u0003052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020:H\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010<J0\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u0003052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020:H\u0001ø\u0001\u0000¢\u0006\u0004\bR\u0010<J0\u0010S\u001a\b\u0012\u0004\u0012\u00020\u0003052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020:H\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010<R\u0019\u0010\u000b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u0011\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u001d\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u0015\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010!\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010)\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010-\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010%\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u0019\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u0012\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u001e\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u0016\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\"\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010*\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010.\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010&\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u001a\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u000f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u001b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u0013\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u001f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010'\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010+\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010#\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u0017\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0014\u00101\u001a\u00020\u000e8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u0010\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u001c\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u0014\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010 \u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010(\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010,\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010$\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100R\u0019\u0010\u0018\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00100\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006U"}, d2 = {"Landroidx/compose/material3/TextFieldColors;", "", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "textSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "selectionColors", "getSelectionColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "containerColor", "Landroidx/compose/runtime/State;", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "containerColor$material3_release", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "cursorColor$material3_release", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "indicatorColor", "indicatorColor$material3_release", "labelColor", "labelColor$material3_release", "leadingIconColor", "leadingIconColor$material3_release", "placeholderColor", "placeholderColor$material3_release", "prefixColor", "prefixColor$material3_release", "suffixColor", "suffixColor$material3_release", "supportingTextColor", "supportingTextColor$material3_release", "textColor", "textColor$material3_release", "trailingIconColor", "trailingIconColor$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldColors {
    public static final int $stable = 0;
    private final long cursorColor;
    private final long disabledContainerColor;
    private final long disabledIndicatorColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledPlaceholderColor;
    private final long disabledPrefixColor;
    private final long disabledSuffixColor;
    private final long disabledSupportingTextColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long errorContainerColor;
    private final long errorCursorColor;
    private final long errorIndicatorColor;
    private final long errorLabelColor;
    private final long errorLeadingIconColor;
    private final long errorPlaceholderColor;
    private final long errorPrefixColor;
    private final long errorSuffixColor;
    private final long errorSupportingTextColor;
    private final long errorTextColor;
    private final long errorTrailingIconColor;
    private final long focusedContainerColor;
    private final long focusedIndicatorColor;
    private final long focusedLabelColor;
    private final long focusedLeadingIconColor;
    private final long focusedPlaceholderColor;
    private final long focusedPrefixColor;
    private final long focusedSuffixColor;
    private final long focusedSupportingTextColor;
    private final long focusedTextColor;
    private final long focusedTrailingIconColor;
    private final SelectionColors textSelectionColors;
    private final long unfocusedContainerColor;
    private final long unfocusedIndicatorColor;
    private final long unfocusedLabelColor;
    private final long unfocusedLeadingIconColor;
    private final long unfocusedPlaceholderColor;
    private final long unfocusedPrefixColor;
    private final long unfocusedSuffixColor;
    private final long unfocusedSupportingTextColor;
    private final long unfocusedTextColor;
    private final long unfocusedTrailingIconColor;

    public /* synthetic */ TextFieldColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, SelectionColors selectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, selectionColors, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, j37, j38, j39, j40, j41, j42);
    }

    private TextFieldColors(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long focusedContainerColor, long unfocusedContainerColor, long disabledContainerColor, long errorContainerColor, long cursorColor, long errorCursorColor, SelectionColors textSelectionColors, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedSupportingTextColor, long unfocusedSupportingTextColor, long disabledSupportingTextColor, long errorSupportingTextColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor) {
        Intrinsics.checkNotNullParameter(textSelectionColors, "textSelectionColors");
        this.focusedTextColor = focusedTextColor;
        this.unfocusedTextColor = unfocusedTextColor;
        this.disabledTextColor = disabledTextColor;
        this.errorTextColor = errorTextColor;
        this.focusedContainerColor = focusedContainerColor;
        this.unfocusedContainerColor = unfocusedContainerColor;
        this.disabledContainerColor = disabledContainerColor;
        this.errorContainerColor = errorContainerColor;
        this.cursorColor = cursorColor;
        this.errorCursorColor = errorCursorColor;
        this.textSelectionColors = textSelectionColors;
        this.focusedIndicatorColor = focusedIndicatorColor;
        this.unfocusedIndicatorColor = unfocusedIndicatorColor;
        this.disabledIndicatorColor = disabledIndicatorColor;
        this.errorIndicatorColor = errorIndicatorColor;
        this.focusedLeadingIconColor = focusedLeadingIconColor;
        this.unfocusedLeadingIconColor = unfocusedLeadingIconColor;
        this.disabledLeadingIconColor = disabledLeadingIconColor;
        this.errorLeadingIconColor = errorLeadingIconColor;
        this.focusedTrailingIconColor = focusedTrailingIconColor;
        this.unfocusedTrailingIconColor = unfocusedTrailingIconColor;
        this.disabledTrailingIconColor = disabledTrailingIconColor;
        this.errorTrailingIconColor = errorTrailingIconColor;
        this.focusedLabelColor = focusedLabelColor;
        this.unfocusedLabelColor = unfocusedLabelColor;
        this.disabledLabelColor = disabledLabelColor;
        this.errorLabelColor = errorLabelColor;
        this.focusedPlaceholderColor = focusedPlaceholderColor;
        this.unfocusedPlaceholderColor = unfocusedPlaceholderColor;
        this.disabledPlaceholderColor = disabledPlaceholderColor;
        this.errorPlaceholderColor = errorPlaceholderColor;
        this.focusedSupportingTextColor = focusedSupportingTextColor;
        this.unfocusedSupportingTextColor = unfocusedSupportingTextColor;
        this.disabledSupportingTextColor = disabledSupportingTextColor;
        this.errorSupportingTextColor = errorSupportingTextColor;
        this.focusedPrefixColor = focusedPrefixColor;
        this.unfocusedPrefixColor = unfocusedPrefixColor;
        this.disabledPrefixColor = disabledPrefixColor;
        this.errorPrefixColor = errorPrefixColor;
        this.focusedSuffixColor = focusedSuffixColor;
        this.unfocusedSuffixColor = unfocusedSuffixColor;
        this.disabledSuffixColor = disabledSuffixColor;
        this.errorSuffixColor = errorSuffixColor;
    }

    public final State<Color> leadingIconColor$material3_release(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        long j;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(925127045);
        ComposerKt.sourceInformation($composer, "C(leadingIconColor)P(!1,2)1753@97489L25,1755@97531L267:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(925127045, $changed, -1, "androidx.compose.material3.TextFieldColors.leadingIconColor (TextFieldDefaults.kt:1748)");
        }
        State focused$delegate = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer, ($changed >> 6) & 14);
        if (!enabled) {
            j = this.disabledLeadingIconColor;
        } else if (isError) {
            j = this.errorLeadingIconColor;
        } else {
            j = leadingIconColor$lambda$0(focused$delegate) ? this.focusedLeadingIconColor : this.unfocusedLeadingIconColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(j), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    private static final boolean leadingIconColor$lambda$0(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    public final State<Color> trailingIconColor$material3_release(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        long j;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(-109504137);
        ComposerKt.sourceInformation($composer, "C(trailingIconColor)P(!1,2)1779@98384L25,1781@98426L271:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-109504137, $changed, -1, "androidx.compose.material3.TextFieldColors.trailingIconColor (TextFieldDefaults.kt:1774)");
        }
        State focused$delegate = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer, ($changed >> 6) & 14);
        if (!enabled) {
            j = this.disabledTrailingIconColor;
        } else if (isError) {
            j = this.errorTrailingIconColor;
        } else {
            j = trailingIconColor$lambda$1(focused$delegate) ? this.focusedTrailingIconColor : this.unfocusedTrailingIconColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(j), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    private static final boolean trailingIconColor$lambda$1(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    public final State<Color> indicatorColor$material3_release(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        long targetValue;
        State<Color> rememberUpdatedState;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(-1877482635);
        ComposerKt.sourceInformation($composer, "C(indicatorColor)P(!1,2)1805@99283L25:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1877482635, $changed, -1, "androidx.compose.material3.TextFieldColors.indicatorColor (TextFieldDefaults.kt:1800)");
        }
        State focused$delegate = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer, ($changed >> 6) & 14);
        if (!enabled) {
            targetValue = this.disabledIndicatorColor;
        } else if (isError) {
            targetValue = this.errorIndicatorColor;
        } else {
            targetValue = indicatorColor$lambda$2(focused$delegate) ? this.focusedIndicatorColor : this.unfocusedIndicatorColor;
        }
        if (enabled) {
            $composer.startReplaceableGroup(715788864);
            ComposerKt.sourceInformation($composer, "1814@99574L75");
            rememberUpdatedState = SingleValueAnimationKt.m72animateColorAsStateeuL9pac(targetValue, AnimationSpecKt.tween$default(150, 0, null, 6, null), null, null, $composer, 48, 12);
            $composer.endReplaceableGroup();
        } else {
            $composer.startReplaceableGroup(715788969);
            ComposerKt.sourceInformation($composer, "1816@99679L33");
            rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(targetValue), $composer, 0);
            $composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    private static final boolean indicatorColor$lambda$2(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    public final State<Color> containerColor$material3_release(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        long targetValue;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(-1921164569);
        ComposerKt.sourceInformation($composer, "C(containerColor)P(!1,2)1834@100289L25,1842@100553L75:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1921164569, $changed, -1, "androidx.compose.material3.TextFieldColors.containerColor (TextFieldDefaults.kt:1829)");
        }
        State focused$delegate = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer, ($changed >> 6) & 14);
        if (!enabled) {
            targetValue = this.disabledContainerColor;
        } else if (isError) {
            targetValue = this.errorContainerColor;
        } else {
            targetValue = containerColor$lambda$3(focused$delegate) ? this.focusedContainerColor : this.unfocusedContainerColor;
        }
        State<Color> m72animateColorAsStateeuL9pac = SingleValueAnimationKt.m72animateColorAsStateeuL9pac(targetValue, AnimationSpecKt.tween$default(150, 0, null, 6, null), null, null, $composer, 48, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m72animateColorAsStateeuL9pac;
    }

    private static final boolean containerColor$lambda$3(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    public final State<Color> placeholderColor$material3_release(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        long targetValue;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(653850713);
        ComposerKt.sourceInformation($composer, "C(placeholderColor)P(!1,2)1859@101211L25,1867@101483L33:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(653850713, $changed, -1, "androidx.compose.material3.TextFieldColors.placeholderColor (TextFieldDefaults.kt:1854)");
        }
        State focused$delegate = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer, ($changed >> 6) & 14);
        if (!enabled) {
            targetValue = this.disabledPlaceholderColor;
        } else if (isError) {
            targetValue = this.errorPlaceholderColor;
        } else {
            targetValue = placeholderColor$lambda$4(focused$delegate) ? this.focusedPlaceholderColor : this.unfocusedPlaceholderColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(targetValue), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    private static final boolean placeholderColor$lambda$4(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    public final State<Color> labelColor$material3_release(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        long targetValue;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(1167161306);
        ComposerKt.sourceInformation($composer, "C(labelColor)P(!1,2)1884@102087L25,1892@102335L33:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1167161306, $changed, -1, "androidx.compose.material3.TextFieldColors.labelColor (TextFieldDefaults.kt:1879)");
        }
        State focused$delegate = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer, ($changed >> 6) & 14);
        if (!enabled) {
            targetValue = this.disabledLabelColor;
        } else if (isError) {
            targetValue = this.errorLabelColor;
        } else {
            targetValue = labelColor$lambda$5(focused$delegate) ? this.focusedLabelColor : this.unfocusedLabelColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(targetValue), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    private static final boolean labelColor$lambda$5(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    public final State<Color> textColor$material3_release(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        long targetValue;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(68412911);
        ComposerKt.sourceInformation($composer, "C(textColor)P(!1,2)1909@102944L25,1917@103188L33:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(68412911, $changed, -1, "androidx.compose.material3.TextFieldColors.textColor (TextFieldDefaults.kt:1904)");
        }
        State focused$delegate = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer, ($changed >> 6) & 14);
        if (!enabled) {
            targetValue = this.disabledTextColor;
        } else if (isError) {
            targetValue = this.errorTextColor;
        } else {
            targetValue = textColor$lambda$6(focused$delegate) ? this.focusedTextColor : this.unfocusedTextColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(targetValue), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    private static final boolean textColor$lambda$6(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    public final State<Color> supportingTextColor$material3_release(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        long j;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(1464709698);
        ComposerKt.sourceInformation($composer, "C(supportingTextColor)P(!1,2)1926@103443L25,1928@103485L279:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1464709698, $changed, -1, "androidx.compose.material3.TextFieldColors.supportingTextColor (TextFieldDefaults.kt:1921)");
        }
        State focused$delegate = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer, ($changed >> 6) & 14);
        if (!enabled) {
            j = this.disabledSupportingTextColor;
        } else if (isError) {
            j = this.errorSupportingTextColor;
        } else {
            j = supportingTextColor$lambda$7(focused$delegate) ? this.focusedSupportingTextColor : this.unfocusedSupportingTextColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(j), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    private static final boolean supportingTextColor$lambda$7(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    public final State<Color> prefixColor$material3_release(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        long targetValue;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(129569364);
        ComposerKt.sourceInformation($composer, "C(prefixColor)P(!1,2)1952@104337L25,1960@104589L33:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(129569364, $changed, -1, "androidx.compose.material3.TextFieldColors.prefixColor (TextFieldDefaults.kt:1947)");
        }
        State focused$delegate = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer, ($changed >> 6) & 14);
        if (!enabled) {
            targetValue = this.disabledPrefixColor;
        } else if (isError) {
            targetValue = this.errorPrefixColor;
        } else {
            targetValue = prefixColor$lambda$8(focused$delegate) ? this.focusedPrefixColor : this.unfocusedPrefixColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(targetValue), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    private static final boolean prefixColor$lambda$8(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    public final State<Color> suffixColor$material3_release(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        long targetValue;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(1575329427);
        ComposerKt.sourceInformation($composer, "C(suffixColor)P(!1,2)1977@105195L25,1985@105447L33:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1575329427, $changed, -1, "androidx.compose.material3.TextFieldColors.suffixColor (TextFieldDefaults.kt:1972)");
        }
        State focused$delegate = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer, ($changed >> 6) & 14);
        if (!enabled) {
            targetValue = this.disabledSuffixColor;
        } else if (isError) {
            targetValue = this.errorSuffixColor;
        } else {
            targetValue = suffixColor$lambda$9(focused$delegate) ? this.focusedSuffixColor : this.unfocusedSuffixColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(targetValue), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    private static final boolean suffixColor$lambda$9(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    public final State<Color> cursorColor$material3_release(boolean isError, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1885422187);
        ComposerKt.sourceInformation($composer, "C(cursorColor)1995@105746L68:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1885422187, $changed, -1, "androidx.compose.material3.TextFieldColors.cursorColor (TextFieldDefaults.kt:1994)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(isError ? this.errorCursorColor : this.cursorColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final SelectionColors getSelectionColors(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(997785083);
        ComposerKt.sourceInformation($composer, "C:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(997785083, $changed, -1, "androidx.compose.material3.TextFieldColors.<get-selectionColors> (TextFieldDefaults.kt:2002)");
        }
        SelectionColors selectionColors = this.textSelectionColors;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return selectionColors;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && (other instanceof TextFieldColors) && Color.m2950equalsimpl0(this.focusedTextColor, ((TextFieldColors) other).focusedTextColor) && Color.m2950equalsimpl0(this.unfocusedTextColor, ((TextFieldColors) other).unfocusedTextColor) && Color.m2950equalsimpl0(this.disabledTextColor, ((TextFieldColors) other).disabledTextColor) && Color.m2950equalsimpl0(this.errorTextColor, ((TextFieldColors) other).errorTextColor) && Color.m2950equalsimpl0(this.focusedContainerColor, ((TextFieldColors) other).focusedContainerColor) && Color.m2950equalsimpl0(this.unfocusedContainerColor, ((TextFieldColors) other).unfocusedContainerColor) && Color.m2950equalsimpl0(this.disabledContainerColor, ((TextFieldColors) other).disabledContainerColor) && Color.m2950equalsimpl0(this.errorContainerColor, ((TextFieldColors) other).errorContainerColor) && Color.m2950equalsimpl0(this.cursorColor, ((TextFieldColors) other).cursorColor) && Color.m2950equalsimpl0(this.errorCursorColor, ((TextFieldColors) other).errorCursorColor) && Intrinsics.areEqual(this.textSelectionColors, ((TextFieldColors) other).textSelectionColors) && Color.m2950equalsimpl0(this.focusedIndicatorColor, ((TextFieldColors) other).focusedIndicatorColor) && Color.m2950equalsimpl0(this.unfocusedIndicatorColor, ((TextFieldColors) other).unfocusedIndicatorColor) && Color.m2950equalsimpl0(this.disabledIndicatorColor, ((TextFieldColors) other).disabledIndicatorColor) && Color.m2950equalsimpl0(this.errorIndicatorColor, ((TextFieldColors) other).errorIndicatorColor) && Color.m2950equalsimpl0(this.focusedLeadingIconColor, ((TextFieldColors) other).focusedLeadingIconColor) && Color.m2950equalsimpl0(this.unfocusedLeadingIconColor, ((TextFieldColors) other).unfocusedLeadingIconColor) && Color.m2950equalsimpl0(this.disabledLeadingIconColor, ((TextFieldColors) other).disabledLeadingIconColor) && Color.m2950equalsimpl0(this.errorLeadingIconColor, ((TextFieldColors) other).errorLeadingIconColor) && Color.m2950equalsimpl0(this.focusedTrailingIconColor, ((TextFieldColors) other).focusedTrailingIconColor) && Color.m2950equalsimpl0(this.unfocusedTrailingIconColor, ((TextFieldColors) other).unfocusedTrailingIconColor) && Color.m2950equalsimpl0(this.disabledTrailingIconColor, ((TextFieldColors) other).disabledTrailingIconColor) && Color.m2950equalsimpl0(this.errorTrailingIconColor, ((TextFieldColors) other).errorTrailingIconColor) && Color.m2950equalsimpl0(this.focusedLabelColor, ((TextFieldColors) other).focusedLabelColor) && Color.m2950equalsimpl0(this.unfocusedLabelColor, ((TextFieldColors) other).unfocusedLabelColor) && Color.m2950equalsimpl0(this.disabledLabelColor, ((TextFieldColors) other).disabledLabelColor) && Color.m2950equalsimpl0(this.errorLabelColor, ((TextFieldColors) other).errorLabelColor) && Color.m2950equalsimpl0(this.focusedPlaceholderColor, ((TextFieldColors) other).focusedPlaceholderColor) && Color.m2950equalsimpl0(this.unfocusedPlaceholderColor, ((TextFieldColors) other).unfocusedPlaceholderColor) && Color.m2950equalsimpl0(this.disabledPlaceholderColor, ((TextFieldColors) other).disabledPlaceholderColor) && Color.m2950equalsimpl0(this.errorPlaceholderColor, ((TextFieldColors) other).errorPlaceholderColor) && Color.m2950equalsimpl0(this.focusedSupportingTextColor, ((TextFieldColors) other).focusedSupportingTextColor) && Color.m2950equalsimpl0(this.unfocusedSupportingTextColor, ((TextFieldColors) other).unfocusedSupportingTextColor) && Color.m2950equalsimpl0(this.disabledSupportingTextColor, ((TextFieldColors) other).disabledSupportingTextColor) && Color.m2950equalsimpl0(this.errorSupportingTextColor, ((TextFieldColors) other).errorSupportingTextColor) && Color.m2950equalsimpl0(this.focusedPrefixColor, ((TextFieldColors) other).focusedPrefixColor) && Color.m2950equalsimpl0(this.unfocusedPrefixColor, ((TextFieldColors) other).unfocusedPrefixColor) && Color.m2950equalsimpl0(this.disabledPrefixColor, ((TextFieldColors) other).disabledPrefixColor) && Color.m2950equalsimpl0(this.errorPrefixColor, ((TextFieldColors) other).errorPrefixColor) && Color.m2950equalsimpl0(this.focusedSuffixColor, ((TextFieldColors) other).focusedSuffixColor) && Color.m2950equalsimpl0(this.unfocusedSuffixColor, ((TextFieldColors) other).unfocusedSuffixColor) && Color.m2950equalsimpl0(this.disabledSuffixColor, ((TextFieldColors) other).disabledSuffixColor) && Color.m2950equalsimpl0(this.errorSuffixColor, ((TextFieldColors) other).errorSuffixColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = Color.m2956hashCodeimpl(this.focusedTextColor);
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((result * 31) + Color.m2956hashCodeimpl(this.unfocusedTextColor)) * 31) + Color.m2956hashCodeimpl(this.disabledTextColor)) * 31) + Color.m2956hashCodeimpl(this.errorTextColor)) * 31) + Color.m2956hashCodeimpl(this.focusedContainerColor)) * 31) + Color.m2956hashCodeimpl(this.unfocusedContainerColor)) * 31) + Color.m2956hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m2956hashCodeimpl(this.errorContainerColor)) * 31) + Color.m2956hashCodeimpl(this.cursorColor)) * 31) + Color.m2956hashCodeimpl(this.errorCursorColor)) * 31) + this.textSelectionColors.hashCode()) * 31) + Color.m2956hashCodeimpl(this.focusedIndicatorColor)) * 31) + Color.m2956hashCodeimpl(this.unfocusedIndicatorColor)) * 31) + Color.m2956hashCodeimpl(this.disabledIndicatorColor)) * 31) + Color.m2956hashCodeimpl(this.errorIndicatorColor)) * 31) + Color.m2956hashCodeimpl(this.focusedLeadingIconColor)) * 31) + Color.m2956hashCodeimpl(this.unfocusedLeadingIconColor)) * 31) + Color.m2956hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m2956hashCodeimpl(this.errorLeadingIconColor)) * 31) + Color.m2956hashCodeimpl(this.focusedTrailingIconColor)) * 31) + Color.m2956hashCodeimpl(this.unfocusedTrailingIconColor)) * 31) + Color.m2956hashCodeimpl(this.disabledTrailingIconColor)) * 31) + Color.m2956hashCodeimpl(this.errorTrailingIconColor)) * 31) + Color.m2956hashCodeimpl(this.focusedLabelColor)) * 31) + Color.m2956hashCodeimpl(this.unfocusedLabelColor)) * 31) + Color.m2956hashCodeimpl(this.disabledLabelColor)) * 31) + Color.m2956hashCodeimpl(this.errorLabelColor)) * 31) + Color.m2956hashCodeimpl(this.focusedPlaceholderColor)) * 31) + Color.m2956hashCodeimpl(this.unfocusedPlaceholderColor)) * 31) + Color.m2956hashCodeimpl(this.disabledPlaceholderColor)) * 31) + Color.m2956hashCodeimpl(this.errorPlaceholderColor)) * 31) + Color.m2956hashCodeimpl(this.focusedSupportingTextColor)) * 31) + Color.m2956hashCodeimpl(this.unfocusedSupportingTextColor)) * 31) + Color.m2956hashCodeimpl(this.disabledSupportingTextColor)) * 31) + Color.m2956hashCodeimpl(this.errorSupportingTextColor)) * 31) + Color.m2956hashCodeimpl(this.focusedPrefixColor)) * 31) + Color.m2956hashCodeimpl(this.unfocusedPrefixColor)) * 31) + Color.m2956hashCodeimpl(this.disabledPrefixColor)) * 31) + Color.m2956hashCodeimpl(this.errorPrefixColor)) * 31) + Color.m2956hashCodeimpl(this.focusedSuffixColor)) * 31) + Color.m2956hashCodeimpl(this.unfocusedSuffixColor)) * 31) + Color.m2956hashCodeimpl(this.disabledSuffixColor)) * 31) + Color.m2956hashCodeimpl(this.errorSuffixColor);
    }
}
