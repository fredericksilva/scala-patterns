// ============================================================================
// Sublime SBT config
// ============================================================================

sublimeExternalSourceDirectoryParent <<= baseDirectory { base =>
  base / ".sublime"
}

sublimeTransitive := true

