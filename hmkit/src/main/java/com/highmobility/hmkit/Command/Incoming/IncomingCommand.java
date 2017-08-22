package com.highmobility.hmkit.Command.Incoming;

import com.highmobility.hmkit.ByteUtils;
import com.highmobility.hmkit.Command.Command;
import com.highmobility.hmkit.Command.CommandParseException;

import java.util.Arrays;

/**
 * Created by ttiganik on 07/06/16.
 */
public class IncomingCommand {
    public static IncomingCommand create(byte[] bytes) throws CommandParseException {
        if (bytes.length > 2) {
            if (ByteUtils.startsWith(bytes, Command.Capabilities.CAPABILITIES.getIdentifierAndType())) {
                return new Capabilities(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.Capabilities.CAPABILITY.getIdentifierAndType())) {
                return new Capability(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.VehicleStatus.VEHICLE_STATUS.getIdentifierAndType())) {
                return new VehicleStatus(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.DoorLocks.LOCK_STATE.getIdentifierAndType())) {
                return new LockState(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.TrunkAccess.TRUNK_STATE.getIdentifierAndType())) {
                return new TrunkState(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.Charging.CHARGE_STATE.getIdentifierAndType())) {
                return new ChargeState(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.Climate.CLIMATE_STATE.getIdentifierAndType())) {
                return new ClimateState(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.RooftopControl.ROOFTOP_STATE.getIdentifierAndType())) {
                return new RooftopState(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.RemoteControl.CONTROL_MODE.getIdentifierAndType())) {
                return new ControlMode(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.ValetMode.VALET_MODE.getIdentifierAndType())) {
                return new ValetMode(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.VehicleLocation.VEHICLE_LOCATION.getIdentifierAndType())) {
                return new VehicleLocation(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.DeliveredParcels.DELIVERED_PARCELS.getIdentifierAndType())) {
                return new DeliveredParcels(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.FailureMessage.FAILURE_MESSAGE.getIdentifierAndType())) {
                return new Failure(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.Diagnostics.DIAGNOSTICS_STATE.getIdentifierAndType())) {
                return new DiagnosticsState(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.Maintenance.MAINTENANCE_STATE.getIdentifierAndType())) {
                return new Maintenance(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.Engine.IGNITION_STATE.getIdentifierAndType())) {
                return new IgnitionState(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.Lights.LIGHTS_STATE.getIdentifierAndType())) {
                return new LightsState(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.Messaging.SEND_MESSAGE.getIdentifierAndType())) {
                return new SendMessage(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.Notifications.NOTIFICATION_ACTION.getIdentifierAndType())) {
                return new NotificationAction(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.Notifications.NOTIFICATION.getIdentifierAndType())) {
                return new Notification(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.Windscreen.WINDSCREEN_STATE.getIdentifierAndType())) {
                return new WindscreenState(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.DriverFatigue.DRIVER_FATIGUE_DETECTED.getIdentifierAndType())) {
                return new DriverFatigue(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.TheftAlarm.THEFT_ALARM_STATE.getIdentifierAndType())) {
                return new TheftAlarmState(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.ParkingTicket.PARKING_TICKET.getIdentifierAndType())) {
                return new ParkingTicket(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.KeyfobPosition.KEYFOB_POSITION.getIdentifierAndType())) {
                return new KeyfobPosition(bytes);
            }
            else if (ByteUtils.startsWith(bytes, Command.VehicleTime.VEHICLE_TIME.getIdentifierAndType())) {
                return new VehicleTime(bytes);
            }
            else {
                throw new CommandParseException();
            }
        }
        else if (bytes.length == 0) {
            return new IncomingCommand(bytes);
        }
        else {
            throw new CommandParseException();
        }
    }

    Command.Identifier identifier;
    byte type;
    byte[] bytes;

    IncomingCommand(byte[] bytes) throws CommandParseException {
        if (bytes.length == 0) return; // empty IncomingCommand
        if (bytes.length < 3) throw new CommandParseException();
        this.bytes = bytes;
        identifier = Command.Identifier.fromIdentifier(bytes);
        type = bytes[2];
    }

    public Command.Identifier getIdentifier() {
        return identifier;
    }

    byte getType() {
        return type;
    }

    byte[] getIdentifierAndType() {
        return ByteUtils.concatBytes(identifier.getIdentifier(), type);
    }

    byte[] getBytes() {
        return bytes;
    }

    /**
     *
     * @param type The type to compare the command with.
     * @return True if the command has the given type.
     */
    public boolean is(Command.Type type) {
        if (bytes == null) return false;
        if (Arrays.equals(getIdentifierAndType(), type.getIdentifierAndType())) {
            return true;
        }

        return false;
    }
}