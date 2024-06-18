package androidx.compose.ui.tooling.data;

import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SlotTree.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0002\u0010\u0010J\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0011R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006!"}, d2 = {"Landroidx/compose/ui/tooling/data/SourceInformationContext;", "", HintConstants.AUTOFILL_HINT_NAME, "", "sourceFile", "packageHash", "", "locations", "", "Landroidx/compose/ui/tooling/data/SourceLocationInfo;", "repeatOffset", "parameters", "Landroidx/compose/ui/tooling/data/Parameter;", "isCall", "", "isInline", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;ILjava/util/List;ZZ)V", "()Z", "getLocations", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "nextLocation", "getPackageHash", "()I", "getParameters", "getRepeatOffset", "getSourceFile", "nextSourceLocation", "Landroidx/compose/ui/tooling/data/SourceLocation;", "sourceLocation", "callIndex", "parentContext", "ui-tooling-data_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SourceInformationContext {
    private final boolean isCall;
    private final boolean isInline;
    private final List<SourceLocationInfo> locations;
    private final String name;
    private int nextLocation;
    private final int packageHash;
    private final List<Parameter> parameters;
    private final int repeatOffset;
    private final String sourceFile;

    public SourceInformationContext(String name, String sourceFile, int packageHash, List<SourceLocationInfo> locations, int repeatOffset, List<Parameter> list, boolean isCall, boolean isInline) {
        Intrinsics.checkNotNullParameter(locations, "locations");
        this.name = name;
        this.sourceFile = sourceFile;
        this.packageHash = packageHash;
        this.locations = locations;
        this.repeatOffset = repeatOffset;
        this.parameters = list;
        this.isCall = isCall;
        this.isInline = isInline;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSourceFile() {
        return this.sourceFile;
    }

    public final int getPackageHash() {
        return this.packageHash;
    }

    public final List<SourceLocationInfo> getLocations() {
        return this.locations;
    }

    public final int getRepeatOffset() {
        return this.repeatOffset;
    }

    public final List<Parameter> getParameters() {
        return this.parameters;
    }

    /* renamed from: isCall, reason: from getter */
    public final boolean getIsCall() {
        return this.isCall;
    }

    /* renamed from: isInline, reason: from getter */
    public final boolean getIsInline() {
        return this.isInline;
    }

    public final SourceLocation nextSourceLocation() {
        if (this.nextLocation >= this.locations.size() && this.repeatOffset >= 0) {
            this.nextLocation = this.repeatOffset;
        }
        if (this.nextLocation < this.locations.size()) {
            List<SourceLocationInfo> list = this.locations;
            int i = this.nextLocation;
            this.nextLocation = i + 1;
            SourceLocationInfo location = list.get(i);
            Integer lineNumber = location.getLineNumber();
            int intValue = lineNumber != null ? lineNumber.intValue() : -1;
            Integer offset = location.getOffset();
            int intValue2 = offset != null ? offset.intValue() : -1;
            Integer length = location.getLength();
            return new SourceLocation(intValue, intValue2, length != null ? length.intValue() : -1, this.sourceFile, this.packageHash);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.ui.tooling.data.SourceLocation sourceLocation(int r11, androidx.compose.ui.tooling.data.SourceInformationContext r12) {
        /*
            r10 = this;
            r0 = r11
            java.util.List<androidx.compose.ui.tooling.data.SourceLocationInfo> r1 = r10.locations
            int r1 = r1.size()
            if (r0 < r1) goto L29
            int r1 = r10.repeatOffset
            if (r1 < 0) goto L29
            int r1 = r10.repeatOffset
            java.util.List<androidx.compose.ui.tooling.data.SourceLocationInfo> r2 = r10.locations
            int r2 = r2.size()
            if (r1 >= r2) goto L29
            int r1 = r10.repeatOffset
            int r1 = r11 - r1
            java.util.List<androidx.compose.ui.tooling.data.SourceLocationInfo> r2 = r10.locations
            int r2 = r2.size()
            int r3 = r10.repeatOffset
            int r2 = r2 - r3
            int r1 = r1 % r2
            int r2 = r10.repeatOffset
            int r1 = r1 + r2
            r0 = r1
        L29:
            java.util.List<androidx.compose.ui.tooling.data.SourceLocationInfo> r1 = r10.locations
            int r1 = r1.size()
            r2 = 0
            if (r0 >= r1) goto L91
            java.util.List<androidx.compose.ui.tooling.data.SourceLocationInfo> r1 = r10.locations
            java.lang.Object r1 = r1.get(r0)
            androidx.compose.ui.tooling.data.SourceLocationInfo r1 = (androidx.compose.ui.tooling.data.SourceLocationInfo) r1
            androidx.compose.ui.tooling.data.SourceLocation r9 = new androidx.compose.ui.tooling.data.SourceLocation
            java.lang.Integer r3 = r1.getLineNumber()
            r4 = -1
            if (r3 == 0) goto L49
            int r3 = r3.intValue()
            r5 = r3
            goto L4a
        L49:
            r5 = r4
        L4a:
            java.lang.Integer r3 = r1.getOffset()
            if (r3 == 0) goto L56
            int r3 = r3.intValue()
            r6 = r3
            goto L57
        L56:
            r6 = r4
        L57:
            java.lang.Integer r3 = r1.getLength()
            if (r3 == 0) goto L63
            int r3 = r3.intValue()
            r7 = r3
            goto L64
        L63:
            r7 = r4
        L64:
            java.lang.String r3 = r10.sourceFile
            if (r3 != 0) goto L6f
            if (r12 == 0) goto L6d
            java.lang.String r3 = r12.sourceFile
            goto L6f
        L6d:
            r8 = r2
            goto L70
        L6f:
            r8 = r3
        L70:
            java.lang.String r3 = r10.sourceFile
            if (r3 != 0) goto L79
            if (r12 == 0) goto L7f
            int r2 = r12.packageHash
            goto L7b
        L79:
            int r2 = r10.packageHash
        L7b:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L7f:
            if (r2 == 0) goto L86
            int r2 = r2.intValue()
            goto L87
        L86:
            r2 = r4
        L87:
            r3 = r9
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r2
            r3.<init>(r4, r5, r6, r7, r8)
            return r9
        L91:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.data.SourceInformationContext.sourceLocation(int, androidx.compose.ui.tooling.data.SourceInformationContext):androidx.compose.ui.tooling.data.SourceLocation");
    }
}
