package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ColorScheme.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b|\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bð\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010 Jµ\u0002\u0010|\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b}\u0010~J\t\u0010\u007f\u001a\u00030\u0080\u0001H\u0016R4\u0010\u0010\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R4\u0010\u0019\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b*\u0010'\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R4\u0010\u001b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b-\u0010'\u001a\u0004\b+\u0010#\"\u0004\b,\u0010%R4\u0010\u0018\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b0\u0010'\u001a\u0004\b.\u0010#\"\u0004\b/\u0010%R4\u0010\u0007\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b3\u0010'\u001a\u0004\b1\u0010#\"\u0004\b2\u0010%R4\u0010\u0017\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b6\u0010'\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%R4\u0010\u0011\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b9\u0010'\u001a\u0004\b7\u0010#\"\u0004\b8\u0010%R4\u0010\u001a\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b<\u0010'\u001a\u0004\b:\u0010#\"\u0004\b;\u0010%R4\u0010\u001c\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b?\u0010'\u001a\u0004\b=\u0010#\"\u0004\b>\u0010%R4\u0010\u0004\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bB\u0010'\u001a\u0004\b@\u0010#\"\u0004\bA\u0010%R4\u0010\u0006\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bE\u0010'\u001a\u0004\bC\u0010#\"\u0004\bD\u0010%R4\u0010\t\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bH\u0010'\u001a\u0004\bF\u0010#\"\u0004\bG\u0010%R4\u0010\u000b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bK\u0010'\u001a\u0004\bI\u0010#\"\u0004\bJ\u0010%R4\u0010\u0013\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bN\u0010'\u001a\u0004\bL\u0010#\"\u0004\bM\u0010%R4\u0010\u0015\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bQ\u0010'\u001a\u0004\bO\u0010#\"\u0004\bP\u0010%R4\u0010\r\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bT\u0010'\u001a\u0004\bR\u0010#\"\u0004\bS\u0010%R4\u0010\u000f\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bW\u0010'\u001a\u0004\bU\u0010#\"\u0004\bV\u0010%R4\u0010\u001d\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bZ\u0010'\u001a\u0004\bX\u0010#\"\u0004\bY\u0010%R4\u0010\u001e\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b]\u0010'\u001a\u0004\b[\u0010#\"\u0004\b\\\u0010%R4\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b`\u0010'\u001a\u0004\b^\u0010#\"\u0004\b_\u0010%R4\u0010\u0005\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bc\u0010'\u001a\u0004\ba\u0010#\"\u0004\bb\u0010%R4\u0010\u001f\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bf\u0010'\u001a\u0004\bd\u0010#\"\u0004\be\u0010%R4\u0010\b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bi\u0010'\u001a\u0004\bg\u0010#\"\u0004\bh\u0010%R4\u0010\n\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bl\u0010'\u001a\u0004\bj\u0010#\"\u0004\bk\u0010%R4\u0010\u0012\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bo\u0010'\u001a\u0004\bm\u0010#\"\u0004\bn\u0010%R4\u0010\u0016\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\br\u0010'\u001a\u0004\bp\u0010#\"\u0004\bq\u0010%R4\u0010\u0014\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bu\u0010'\u001a\u0004\bs\u0010#\"\u0004\bt\u0010%R4\u0010\f\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bx\u0010'\u001a\u0004\bv\u0010#\"\u0004\bw\u0010%R4\u0010\u000e\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b{\u0010'\u001a\u0004\by\u0010#\"\u0004\bz\u0010%\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0081\u0001"}, d2 = {"Landroidx/compose/material3/ColorScheme;", "", "primary", "Landroidx/compose/ui/graphics/Color;", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "getBackground-0d7_KjU", "()J", "setBackground-8_81llA$material3_release", "(J)V", "background$delegate", "Landroidx/compose/runtime/MutableState;", "getError-0d7_KjU", "setError-8_81llA$material3_release", "error$delegate", "getErrorContainer-0d7_KjU", "setErrorContainer-8_81llA$material3_release", "errorContainer$delegate", "getInverseOnSurface-0d7_KjU", "setInverseOnSurface-8_81llA$material3_release", "inverseOnSurface$delegate", "getInversePrimary-0d7_KjU", "setInversePrimary-8_81llA$material3_release", "inversePrimary$delegate", "getInverseSurface-0d7_KjU", "setInverseSurface-8_81llA$material3_release", "inverseSurface$delegate", "getOnBackground-0d7_KjU", "setOnBackground-8_81llA$material3_release", "onBackground$delegate", "getOnError-0d7_KjU", "setOnError-8_81llA$material3_release", "onError$delegate", "getOnErrorContainer-0d7_KjU", "setOnErrorContainer-8_81llA$material3_release", "onErrorContainer$delegate", "getOnPrimary-0d7_KjU", "setOnPrimary-8_81llA$material3_release", "onPrimary$delegate", "getOnPrimaryContainer-0d7_KjU", "setOnPrimaryContainer-8_81llA$material3_release", "onPrimaryContainer$delegate", "getOnSecondary-0d7_KjU", "setOnSecondary-8_81llA$material3_release", "onSecondary$delegate", "getOnSecondaryContainer-0d7_KjU", "setOnSecondaryContainer-8_81llA$material3_release", "onSecondaryContainer$delegate", "getOnSurface-0d7_KjU", "setOnSurface-8_81llA$material3_release", "onSurface$delegate", "getOnSurfaceVariant-0d7_KjU", "setOnSurfaceVariant-8_81llA$material3_release", "onSurfaceVariant$delegate", "getOnTertiary-0d7_KjU", "setOnTertiary-8_81llA$material3_release", "onTertiary$delegate", "getOnTertiaryContainer-0d7_KjU", "setOnTertiaryContainer-8_81llA$material3_release", "onTertiaryContainer$delegate", "getOutline-0d7_KjU", "setOutline-8_81llA$material3_release", "outline$delegate", "getOutlineVariant-0d7_KjU", "setOutlineVariant-8_81llA$material3_release", "outlineVariant$delegate", "getPrimary-0d7_KjU", "setPrimary-8_81llA$material3_release", "primary$delegate", "getPrimaryContainer-0d7_KjU", "setPrimaryContainer-8_81llA$material3_release", "primaryContainer$delegate", "getScrim-0d7_KjU", "setScrim-8_81llA$material3_release", "scrim$delegate", "getSecondary-0d7_KjU", "setSecondary-8_81llA$material3_release", "secondary$delegate", "getSecondaryContainer-0d7_KjU", "setSecondaryContainer-8_81llA$material3_release", "secondaryContainer$delegate", "getSurface-0d7_KjU", "setSurface-8_81llA$material3_release", "surface$delegate", "getSurfaceTint-0d7_KjU", "setSurfaceTint-8_81llA$material3_release", "surfaceTint$delegate", "getSurfaceVariant-0d7_KjU", "setSurfaceVariant-8_81llA$material3_release", "surfaceVariant$delegate", "getTertiary-0d7_KjU", "setTertiary-8_81llA$material3_release", "tertiary$delegate", "getTertiaryContainer-0d7_KjU", "setTertiaryContainer-8_81llA$material3_release", "tertiaryContainer$delegate", "copy", "copy-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ColorScheme {
    public static final int $stable = 0;

    /* renamed from: background$delegate, reason: from kotlin metadata */
    private final MutableState background;

    /* renamed from: error$delegate, reason: from kotlin metadata */
    private final MutableState error;

    /* renamed from: errorContainer$delegate, reason: from kotlin metadata */
    private final MutableState errorContainer;

    /* renamed from: inverseOnSurface$delegate, reason: from kotlin metadata */
    private final MutableState inverseOnSurface;

    /* renamed from: inversePrimary$delegate, reason: from kotlin metadata */
    private final MutableState inversePrimary;

    /* renamed from: inverseSurface$delegate, reason: from kotlin metadata */
    private final MutableState inverseSurface;

    /* renamed from: onBackground$delegate, reason: from kotlin metadata */
    private final MutableState onBackground;

    /* renamed from: onError$delegate, reason: from kotlin metadata */
    private final MutableState onError;

    /* renamed from: onErrorContainer$delegate, reason: from kotlin metadata */
    private final MutableState onErrorContainer;

    /* renamed from: onPrimary$delegate, reason: from kotlin metadata */
    private final MutableState onPrimary;

    /* renamed from: onPrimaryContainer$delegate, reason: from kotlin metadata */
    private final MutableState onPrimaryContainer;

    /* renamed from: onSecondary$delegate, reason: from kotlin metadata */
    private final MutableState onSecondary;

    /* renamed from: onSecondaryContainer$delegate, reason: from kotlin metadata */
    private final MutableState onSecondaryContainer;

    /* renamed from: onSurface$delegate, reason: from kotlin metadata */
    private final MutableState onSurface;

    /* renamed from: onSurfaceVariant$delegate, reason: from kotlin metadata */
    private final MutableState onSurfaceVariant;

    /* renamed from: onTertiary$delegate, reason: from kotlin metadata */
    private final MutableState onTertiary;

    /* renamed from: onTertiaryContainer$delegate, reason: from kotlin metadata */
    private final MutableState onTertiaryContainer;

    /* renamed from: outline$delegate, reason: from kotlin metadata */
    private final MutableState outline;

    /* renamed from: outlineVariant$delegate, reason: from kotlin metadata */
    private final MutableState outlineVariant;

    /* renamed from: primary$delegate, reason: from kotlin metadata */
    private final MutableState primary;

    /* renamed from: primaryContainer$delegate, reason: from kotlin metadata */
    private final MutableState primaryContainer;

    /* renamed from: scrim$delegate, reason: from kotlin metadata */
    private final MutableState scrim;

    /* renamed from: secondary$delegate, reason: from kotlin metadata */
    private final MutableState secondary;

    /* renamed from: secondaryContainer$delegate, reason: from kotlin metadata */
    private final MutableState secondaryContainer;

    /* renamed from: surface$delegate, reason: from kotlin metadata */
    private final MutableState surface;

    /* renamed from: surfaceTint$delegate, reason: from kotlin metadata */
    private final MutableState surfaceTint;

    /* renamed from: surfaceVariant$delegate, reason: from kotlin metadata */
    private final MutableState surfaceVariant;

    /* renamed from: tertiary$delegate, reason: from kotlin metadata */
    private final MutableState tertiary;

    /* renamed from: tertiaryContainer$delegate, reason: from kotlin metadata */
    private final MutableState tertiaryContainer;

    public /* synthetic */ ColorScheme(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29);
    }

    private ColorScheme(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim) {
        this.primary = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(primary), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(onPrimary), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryContainer = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(primaryContainer), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimaryContainer = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(onPrimaryContainer), SnapshotStateKt.structuralEqualityPolicy());
        this.inversePrimary = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(inversePrimary), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(secondary), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(onSecondary), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryContainer = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(secondaryContainer), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondaryContainer = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(onSecondaryContainer), SnapshotStateKt.structuralEqualityPolicy());
        this.tertiary = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(tertiary), SnapshotStateKt.structuralEqualityPolicy());
        this.onTertiary = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(onTertiary), SnapshotStateKt.structuralEqualityPolicy());
        this.tertiaryContainer = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(tertiaryContainer), SnapshotStateKt.structuralEqualityPolicy());
        this.onTertiaryContainer = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(onTertiaryContainer), SnapshotStateKt.structuralEqualityPolicy());
        this.background = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(background), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(onBackground), SnapshotStateKt.structuralEqualityPolicy());
        this.surface = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(surface), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(onSurface), SnapshotStateKt.structuralEqualityPolicy());
        this.surfaceVariant = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(surfaceVariant), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurfaceVariant = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(onSurfaceVariant), SnapshotStateKt.structuralEqualityPolicy());
        this.surfaceTint = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(surfaceTint), SnapshotStateKt.structuralEqualityPolicy());
        this.inverseSurface = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(inverseSurface), SnapshotStateKt.structuralEqualityPolicy());
        this.inverseOnSurface = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(inverseOnSurface), SnapshotStateKt.structuralEqualityPolicy());
        this.error = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(error), SnapshotStateKt.structuralEqualityPolicy());
        this.onError = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(onError), SnapshotStateKt.structuralEqualityPolicy());
        this.errorContainer = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(errorContainer), SnapshotStateKt.structuralEqualityPolicy());
        this.onErrorContainer = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(onErrorContainer), SnapshotStateKt.structuralEqualityPolicy());
        this.outline = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(outline), SnapshotStateKt.structuralEqualityPolicy());
        this.outlineVariant = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(outlineVariant), SnapshotStateKt.structuralEqualityPolicy());
        this.scrim = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(scrim), SnapshotStateKt.structuralEqualityPolicy());
    }

    /* renamed from: getPrimary-0d7_KjU, reason: not valid java name */
    public final long m1373getPrimary0d7_KjU() {
        State $this$getValue$iv = this.primary;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setPrimary-8_81llA$material3_release, reason: not valid java name */
    public final void m1402setPrimary8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.primary;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getOnPrimary-0d7_KjU, reason: not valid java name */
    public final long m1363getOnPrimary0d7_KjU() {
        State $this$getValue$iv = this.onPrimary;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setOnPrimary-8_81llA$material3_release, reason: not valid java name */
    public final void m1392setOnPrimary8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.onPrimary;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getPrimaryContainer-0d7_KjU, reason: not valid java name */
    public final long m1374getPrimaryContainer0d7_KjU() {
        State $this$getValue$iv = this.primaryContainer;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setPrimaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1403setPrimaryContainer8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.primaryContainer;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getOnPrimaryContainer-0d7_KjU, reason: not valid java name */
    public final long m1364getOnPrimaryContainer0d7_KjU() {
        State $this$getValue$iv = this.onPrimaryContainer;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setOnPrimaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1393setOnPrimaryContainer8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.onPrimaryContainer;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getInversePrimary-0d7_KjU, reason: not valid java name */
    public final long m1358getInversePrimary0d7_KjU() {
        State $this$getValue$iv = this.inversePrimary;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setInversePrimary-8_81llA$material3_release, reason: not valid java name */
    public final void m1387setInversePrimary8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.inversePrimary;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getSecondary-0d7_KjU, reason: not valid java name */
    public final long m1376getSecondary0d7_KjU() {
        State $this$getValue$iv = this.secondary;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setSecondary-8_81llA$material3_release, reason: not valid java name */
    public final void m1405setSecondary8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.secondary;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getOnSecondary-0d7_KjU, reason: not valid java name */
    public final long m1365getOnSecondary0d7_KjU() {
        State $this$getValue$iv = this.onSecondary;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setOnSecondary-8_81llA$material3_release, reason: not valid java name */
    public final void m1394setOnSecondary8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.onSecondary;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getSecondaryContainer-0d7_KjU, reason: not valid java name */
    public final long m1377getSecondaryContainer0d7_KjU() {
        State $this$getValue$iv = this.secondaryContainer;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setSecondaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1406setSecondaryContainer8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.secondaryContainer;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getOnSecondaryContainer-0d7_KjU, reason: not valid java name */
    public final long m1366getOnSecondaryContainer0d7_KjU() {
        State $this$getValue$iv = this.onSecondaryContainer;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setOnSecondaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1395setOnSecondaryContainer8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.onSecondaryContainer;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getTertiary-0d7_KjU, reason: not valid java name */
    public final long m1381getTertiary0d7_KjU() {
        State $this$getValue$iv = this.tertiary;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setTertiary-8_81llA$material3_release, reason: not valid java name */
    public final void m1410setTertiary8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.tertiary;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getOnTertiary-0d7_KjU, reason: not valid java name */
    public final long m1369getOnTertiary0d7_KjU() {
        State $this$getValue$iv = this.onTertiary;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setOnTertiary-8_81llA$material3_release, reason: not valid java name */
    public final void m1398setOnTertiary8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.onTertiary;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getTertiaryContainer-0d7_KjU, reason: not valid java name */
    public final long m1382getTertiaryContainer0d7_KjU() {
        State $this$getValue$iv = this.tertiaryContainer;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setTertiaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1411setTertiaryContainer8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.tertiaryContainer;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getOnTertiaryContainer-0d7_KjU, reason: not valid java name */
    public final long m1370getOnTertiaryContainer0d7_KjU() {
        State $this$getValue$iv = this.onTertiaryContainer;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setOnTertiaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1399setOnTertiaryContainer8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.onTertiaryContainer;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m1354getBackground0d7_KjU() {
        State $this$getValue$iv = this.background;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setBackground-8_81llA$material3_release, reason: not valid java name */
    public final void m1383setBackground8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.background;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getOnBackground-0d7_KjU, reason: not valid java name */
    public final long m1360getOnBackground0d7_KjU() {
        State $this$getValue$iv = this.onBackground;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setOnBackground-8_81llA$material3_release, reason: not valid java name */
    public final void m1389setOnBackground8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.onBackground;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getSurface-0d7_KjU, reason: not valid java name */
    public final long m1378getSurface0d7_KjU() {
        State $this$getValue$iv = this.surface;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setSurface-8_81llA$material3_release, reason: not valid java name */
    public final void m1407setSurface8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.surface;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getOnSurface-0d7_KjU, reason: not valid java name */
    public final long m1367getOnSurface0d7_KjU() {
        State $this$getValue$iv = this.onSurface;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setOnSurface-8_81llA$material3_release, reason: not valid java name */
    public final void m1396setOnSurface8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.onSurface;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getSurfaceVariant-0d7_KjU, reason: not valid java name */
    public final long m1380getSurfaceVariant0d7_KjU() {
        State $this$getValue$iv = this.surfaceVariant;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setSurfaceVariant-8_81llA$material3_release, reason: not valid java name */
    public final void m1409setSurfaceVariant8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.surfaceVariant;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getOnSurfaceVariant-0d7_KjU, reason: not valid java name */
    public final long m1368getOnSurfaceVariant0d7_KjU() {
        State $this$getValue$iv = this.onSurfaceVariant;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setOnSurfaceVariant-8_81llA$material3_release, reason: not valid java name */
    public final void m1397setOnSurfaceVariant8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.onSurfaceVariant;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getSurfaceTint-0d7_KjU, reason: not valid java name */
    public final long m1379getSurfaceTint0d7_KjU() {
        State $this$getValue$iv = this.surfaceTint;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setSurfaceTint-8_81llA$material3_release, reason: not valid java name */
    public final void m1408setSurfaceTint8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.surfaceTint;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getInverseSurface-0d7_KjU, reason: not valid java name */
    public final long m1359getInverseSurface0d7_KjU() {
        State $this$getValue$iv = this.inverseSurface;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setInverseSurface-8_81llA$material3_release, reason: not valid java name */
    public final void m1388setInverseSurface8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.inverseSurface;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getInverseOnSurface-0d7_KjU, reason: not valid java name */
    public final long m1357getInverseOnSurface0d7_KjU() {
        State $this$getValue$iv = this.inverseOnSurface;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setInverseOnSurface-8_81llA$material3_release, reason: not valid java name */
    public final void m1386setInverseOnSurface8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.inverseOnSurface;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getError-0d7_KjU, reason: not valid java name */
    public final long m1355getError0d7_KjU() {
        State $this$getValue$iv = this.error;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setError-8_81llA$material3_release, reason: not valid java name */
    public final void m1384setError8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.error;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getOnError-0d7_KjU, reason: not valid java name */
    public final long m1361getOnError0d7_KjU() {
        State $this$getValue$iv = this.onError;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setOnError-8_81llA$material3_release, reason: not valid java name */
    public final void m1390setOnError8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.onError;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getErrorContainer-0d7_KjU, reason: not valid java name */
    public final long m1356getErrorContainer0d7_KjU() {
        State $this$getValue$iv = this.errorContainer;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setErrorContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1385setErrorContainer8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.errorContainer;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getOnErrorContainer-0d7_KjU, reason: not valid java name */
    public final long m1362getOnErrorContainer0d7_KjU() {
        State $this$getValue$iv = this.onErrorContainer;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setOnErrorContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1391setOnErrorContainer8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.onErrorContainer;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getOutline-0d7_KjU, reason: not valid java name */
    public final long m1371getOutline0d7_KjU() {
        State $this$getValue$iv = this.outline;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setOutline-8_81llA$material3_release, reason: not valid java name */
    public final void m1400setOutline8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.outline;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getOutlineVariant-0d7_KjU, reason: not valid java name */
    public final long m1372getOutlineVariant0d7_KjU() {
        State $this$getValue$iv = this.outlineVariant;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setOutlineVariant-8_81llA$material3_release, reason: not valid java name */
    public final void m1401setOutlineVariant8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.outlineVariant;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getScrim-0d7_KjU, reason: not valid java name */
    public final long m1375getScrim0d7_KjU() {
        State $this$getValue$iv = this.scrim;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setScrim-8_81llA$material3_release, reason: not valid java name */
    public final void m1404setScrim8_81llA$material3_release(long j) {
        MutableState $this$setValue$iv = this.scrim;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: copy-G1PFc-w, reason: not valid java name */
    public final ColorScheme m1353copyG1PFcw(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim) {
        return new ColorScheme(primary, onPrimary, primaryContainer, onPrimaryContainer, inversePrimary, secondary, onSecondary, secondaryContainer, onSecondaryContainer, tertiary, onTertiary, tertiaryContainer, onTertiaryContainer, background, onBackground, surface, onSurface, surfaceVariant, onSurfaceVariant, surfaceTint, inverseSurface, inverseOnSurface, error, onError, errorContainer, onErrorContainer, outline, outlineVariant, scrim, null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorScheme(primary=").append((Object) Color.m2957toStringimpl(m1373getPrimary0d7_KjU())).append("onPrimary=").append((Object) Color.m2957toStringimpl(m1363getOnPrimary0d7_KjU())).append("primaryContainer=").append((Object) Color.m2957toStringimpl(m1374getPrimaryContainer0d7_KjU())).append("onPrimaryContainer=").append((Object) Color.m2957toStringimpl(m1364getOnPrimaryContainer0d7_KjU())).append("inversePrimary=").append((Object) Color.m2957toStringimpl(m1358getInversePrimary0d7_KjU())).append("secondary=").append((Object) Color.m2957toStringimpl(m1376getSecondary0d7_KjU())).append("onSecondary=").append((Object) Color.m2957toStringimpl(m1365getOnSecondary0d7_KjU())).append("secondaryContainer=").append((Object) Color.m2957toStringimpl(m1377getSecondaryContainer0d7_KjU())).append("onSecondaryContainer=").append((Object) Color.m2957toStringimpl(m1366getOnSecondaryContainer0d7_KjU())).append("tertiary=").append((Object) Color.m2957toStringimpl(m1381getTertiary0d7_KjU())).append("onTertiary=").append((Object) Color.m2957toStringimpl(m1369getOnTertiary0d7_KjU())).append("tertiaryContainer=");
        sb.append((Object) Color.m2957toStringimpl(m1382getTertiaryContainer0d7_KjU())).append("onTertiaryContainer=").append((Object) Color.m2957toStringimpl(m1370getOnTertiaryContainer0d7_KjU())).append("background=").append((Object) Color.m2957toStringimpl(m1354getBackground0d7_KjU())).append("onBackground=").append((Object) Color.m2957toStringimpl(m1360getOnBackground0d7_KjU())).append("surface=").append((Object) Color.m2957toStringimpl(m1378getSurface0d7_KjU())).append("onSurface=").append((Object) Color.m2957toStringimpl(m1367getOnSurface0d7_KjU())).append("surfaceVariant=").append((Object) Color.m2957toStringimpl(m1380getSurfaceVariant0d7_KjU())).append("onSurfaceVariant=").append((Object) Color.m2957toStringimpl(m1368getOnSurfaceVariant0d7_KjU())).append("surfaceTint=").append((Object) Color.m2957toStringimpl(m1379getSurfaceTint0d7_KjU())).append("inverseSurface=").append((Object) Color.m2957toStringimpl(m1359getInverseSurface0d7_KjU())).append("inverseOnSurface=").append((Object) Color.m2957toStringimpl(m1357getInverseOnSurface0d7_KjU())).append("error=").append((Object) Color.m2957toStringimpl(m1355getError0d7_KjU()));
        sb.append("onError=").append((Object) Color.m2957toStringimpl(m1361getOnError0d7_KjU())).append("errorContainer=").append((Object) Color.m2957toStringimpl(m1356getErrorContainer0d7_KjU())).append("onErrorContainer=").append((Object) Color.m2957toStringimpl(m1362getOnErrorContainer0d7_KjU())).append("outline=").append((Object) Color.m2957toStringimpl(m1371getOutline0d7_KjU())).append("outlineVariant=").append((Object) Color.m2957toStringimpl(m1372getOutlineVariant0d7_KjU())).append("scrim=").append((Object) Color.m2957toStringimpl(m1375getScrim0d7_KjU())).append(')');
        return sb.toString();
    }
}
