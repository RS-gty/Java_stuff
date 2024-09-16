package linalg.matrix;

import data.enums;
import java.lang.Math;

public class RotationMatrix3d extends Matrix3d {
    public enums.Axis RotationAxis;

    public RotationMatrix3d() {
        super();
    }
    public RotationMatrix3d setRotationAxis(enums.Axis axis) {
        RotationAxis = axis;
        return this;
    }
    public RotationMatrix3d setRotationAngle(double angle) {
        if (RotationAxis == null) {
            throw new IllegalStateException();
        } else {
            switch (RotationAxis) {
                case X:
                    this.addColumn(1, 0, 0);
                    this.addColumn(0, Math.cos(angle), -Math.sin(angle));
                    this.addColumn(0, Math.sin(angle), Math.cos(angle));
                    break;
                case Y:
                    this.addColumn(Math.cos(angle), 0, Math.sin(angle));
                    this.addColumn(0, 1, 0);
                    this.addColumn(-Math.sin(angle), 0, Math.cos(angle));
                    break;
                case Z:
                    this.addColumn(Math.cos(angle), -Math.sin(angle), 0);
                    this.addColumn(Math.sin(angle), Math.cos(angle), 0);
                    this.addColumn(0, 0, 1);
                    break;
            }
        }
        return this;
    }
}
