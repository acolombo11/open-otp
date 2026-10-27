# Open OTP

## Issuer icons

Icons live in `shared/src/commonMain/kotlin/ml/dev/kotlin/openotp/ui/icons/`, one file per brand, each exposing an `OtpIcons.<Name>` `ImageVector` (see `Firefox.kt` for the exact format).

- **Source:** the original icons came from the forked project or from the maintainer's personal Figma file. The more recent batch (Apple, Atlassian, Binance, Discord, Docker, Stripe, Zoom, etc.) was generated from the [Simple Icons](https://simpleicons.org) npm package (`npm pack simple-icons`, CC0). Those are monochrome, 24×24 viewport, a single path, filled `0xFF000000`. Brands removed from Simple Icons (e.g. Slack, Heroku, OpenAI) are not available there.
- **Converting:** translate the SVG path `d` attribute into `path { ... }` builder calls, mapping each command to its Compose equivalent, keeping the relative variants as they are (`m`→`moveToRelative`, `c`→`curveToRelative`, `a`→`arcToRelative`, etc.). Handle implicit repeated commands (extra `M` pairs become `lineTo`) and arc flags glued to numbers (`a1 1 0 011 1`). Number format is `1.0f`. Copy the rest of the file boilerplate from an existing icon, including the lazily initialised `_name` backing property.
- **Registering:** add `OtpIcons.<Name>` to the list in `ui/Icons.kt`, keeping it alphabetical.
- **Naming:** lookup is `issuer.contains(icon.name, ignoreCase = true)` and the first match wins, so the `name` given to the `Builder` must be a substring of the issuer as users typically see it (e.g. `Epic` for "Epic Games"). Beware short names that match unrelated issuers. The name must also be a valid Kotlin identifier (no leading digit, so no `1Password` as-is).
- **Verify:** `./gradlew :shared:compileKotlinDesktop`.
