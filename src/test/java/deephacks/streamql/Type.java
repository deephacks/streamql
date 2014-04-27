package deephacks.streamql;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Currency;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class Type {

  private Boolean aBoolean;
  private String aString;
  private TimeUnit aEnum; // all enums are treated same
  private URL url;
  private URI uri;
  private File file;
  private UUID uuid;
  private Currency currency;
  private Pattern pattern;
  private Locale locale;

  private LocalDateTime localDateTime;
  private ZonedDateTime zoneDateTime;
  private ZoneOffset zoneOffset;
  private Period period;
  private Duration duration;

  public Type(Object value) {
    if (value instanceof Boolean) {
      this.aBoolean  = (Boolean) value;
    } else if (value instanceof String) {
      this.aString  = (String) value;
    } else if (value instanceof TimeUnit) {
      this.aEnum  = (TimeUnit) value;
    } else if (value instanceof URL) {
      this.url  = (URL) value;
    } else if (value instanceof URI) {
      this.uri  = (URI) value;
    } else if (value instanceof File) {
      this.file = (File) value;
    } else if (value instanceof UUID) {
      this.uuid  = (UUID) value;
    } else if (value instanceof LocalDateTime) {
      this.localDateTime  = (LocalDateTime) value;
    } else if (value instanceof ZonedDateTime) {
      this.zoneDateTime  = (ZonedDateTime) value;
    } else if (value instanceof ZoneOffset) {
      this.zoneOffset  = (ZoneOffset) value;
    } else if (value instanceof Period) {
      this.period  = (Period) value;
    } else if (value instanceof Duration) {
      this.duration = (Duration) value;
    }
  }

  public Boolean getBoolean() {
    return aBoolean;
  }

  public String getString() {
    return aString;
  }

  public TimeUnit getEnum() {
    return aEnum;
  }

  public URL getUrl() {
    return url;
  }

  public Period getPeriod() {
    return period;
  }

  public Duration getDuration() {
    return duration;
  }

  public LocalDateTime getLocalDateTime() {
    return localDateTime;
  }

  public ZonedDateTime getZonedDateTime() {
    return zoneDateTime;
  }

  public ZoneOffset getZoneOffset() {
    return zoneOffset;
  }

  public URI getUri() {
    return uri;
  }

  public File getFile() {
    return file;
  }

  public UUID getUuid() {
    return uuid;
  }

  public Currency getCurrency() {
    return currency;
  }

  public Pattern getPattern() {
    return pattern;
  }

  public Locale getLocale() {
    return locale;
  }

  public Boolean getaBoolean() {
    return aBoolean;
  }
}